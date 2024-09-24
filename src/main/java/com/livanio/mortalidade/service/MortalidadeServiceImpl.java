package com.livanio.mortalidade.service;

import com.livanio.mortalidade.client.IneMockClient;
import com.livanio.mortalidade.dto.MortalidadeDto;
import com.livanio.mortalidade.dto.Populacao;
import com.livanio.mortalidade.dto.ResponseIne;
import com.livanio.mortalidade.entity.Mortalidade;
import com.livanio.mortalidade.repository.MortalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.livanio.mortalidade.util.UtilHelper.calculaPopulacao;
import static java.math.BigDecimal.valueOf;
import static java.util.List.of;

@Service
public class MortalidadeServiceImpl implements MortalidadeService {
    @Autowired
    MortalidadeRepository repository;
    @Autowired
    IneMockClient ine;

    @Override
    public List<MortalidadeDto> consultarMortalidadePorAno(Long ano) {

        return buildEntityToModel(repository.findByAno(ano));
    }

    @Override
    @Transactional
    public void criarRegistroMortalidade(Long ano, String pais){
        var request = new MortalidadeDto();
        var ineResult = ine.getDadosIne(ano, pais);
        Populacao populacao = getPopulacao(ineResult);

        request.setCodPais(pais);
        request.setAno(ano);
        request.setTxFeminino(valueOf(ineResult.getTaxaMortalidadeFeminina()));
        request.setTxMasculino(valueOf(ineResult.getTaxaMortalidadeMasculina()));
        request.setPopulacaoFeminina(populacao.getPopulacaoFeminina());
        request.setPopulacaoMasculina(populacao.getPopulacaoMasculina());

        buildEntityToModel(of(repository.save(buildModelToEntity(request))));
    }

    @Override
    public MortalidadeDto atualizarRegistroMortalidade(Long ano, String codPais, MortalidadeDto request) {
        var result = repository.findByAnoAndCodPais(ano, codPais);

        var ineResult = ine.getDadosIne(ano, codPais);
        Populacao populacao = getPopulacao(ineResult);

        request.setAno(result.getAno());
        request.setTxMasculino(valueOf(ineResult.getTaxaMortalidadeMasculina()));
        request.setTxFeminino(valueOf(ineResult.getTaxaMortalidadeFeminina()));
        request.setCodPais(result.getCodPais());
        request.setPopulacaoFeminina(populacao.getPopulacaoFeminina());
        request.setPopulacaoMasculina(populacao.getPopulacaoMasculina());

        return buildEntityToModel(of(repository.save(buildModelToEntity(request)))).get(0);
    }

    @Override
    public void uploadDadosMortalidade(String path) throws IOException {
        File estatisticFile = new File(path);
         var estatistica = Files.readAllLines(estatisticFile.toPath())
                 .stream()
                 .map(line -> Arrays.stream(line.split("populacaoFeminina")).toList())
                 .flatMap(Collection::stream)
                 .toList();

         for(String dado : estatistica){
             var dto = new MortalidadeDto();
             dto.setCodPais(dado.split(";")[0]);
             dto.setTxFeminino(new BigDecimal(dado.split(";")[1]));
             dto.setTxMasculino(new BigDecimal(dado.split(";")[2]));
             dto.setAno(Long.valueOf(dado.split(";")[3]));
             dto.setPopulacaoMasculina(Long.valueOf(dado.split(";")[4]));
             dto.setPopulacaoFeminina(Long.valueOf(dado.split(";")[5]));
             of(repository.save(buildModelToEntity(dto)));
         }
    }

    private static Mortalidade buildModelToEntity(MortalidadeDto dto) {
        Mortalidade mortalidade = new Mortalidade();
        mortalidade.setId(dto.getId());
        mortalidade.setCodPais(dto.getCodPais());
        mortalidade.setTxFeminino(dto.getTxFeminino());
        mortalidade.setTxMasculino(dto.getTxMasculino());
        mortalidade.setAno(dto.getAno());
        mortalidade.setPopulacaoFeminina(dto.getPopulacaoFeminina());
        mortalidade.setPupulacaoMasculina(dto.getPopulacaoMasculina());

        return mortalidade;

    }

    private Populacao getPopulacao(ResponseIne ineResult) {
        return calculaPopulacao(ineResult.getObitoMasculino(),
                ineResult.getObitoFeminino(), valueOf((ineResult.getTaxaMortalidadeFeminina())),
                valueOf(ineResult.getTaxaMortalidadeMasculina()));
    }

    private static  List<MortalidadeDto>buildEntityToModel(List<Mortalidade> mortalidades) {

        List<MortalidadeDto> mortalidadeDtoList = new ArrayList<>();
        for(Mortalidade mortalidade : mortalidades) {
            MortalidadeDto dto = new MortalidadeDto();
            dto.setId(mortalidade.getId());
            dto.setCodPais(mortalidade.getCodPais());
            dto.setTxFeminino(mortalidade.getTxFeminino());
            dto.setTxMasculino(mortalidade.getTxMasculino());
            dto.setAno(mortalidade.getAno());
            dto.setPopulacaoMasculina(mortalidade.getPupulacaoMasculina());
            dto.setPopulacaoFeminina(mortalidade.getPopulacaoFeminina());
            mortalidadeDtoList.add(dto);
        }
        return mortalidadeDtoList;
    }

}
