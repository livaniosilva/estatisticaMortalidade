package com.livanio.mortalidade;

import com.livanio.mortalidade.client.IneMockClient;
import com.livanio.mortalidade.dto.MortalidadeDto;
import com.livanio.mortalidade.dto.Populacao;
import com.livanio.mortalidade.dto.ResponseIne;
import com.livanio.mortalidade.entity.Mortalidade;
import com.livanio.mortalidade.repository.MortalidadeRepository;
import com.livanio.mortalidade.service.MortalidadeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MortalidadeServiceTests {

    @Mock
    private MortalidadeRepository repository;

    @Mock
    private IneMockClient ine;

    @InjectMocks
    private MortalidadeServiceImpl mortalidadeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConsultarMortalidadePorAno() {
        Long ano = 2021L;

        Mortalidade mortalidade = new Mortalidade();
        mortalidade.setId(1L);
        mortalidade.setAno(ano);
        mortalidade.setCodPais("BR");
        mortalidade.setTxFeminino(valueOf(10.5));
        mortalidade.setTxMasculino(valueOf(9.8));
        mortalidade.setPopulacaoFeminina(5000000L);
        mortalidade.setPupulacaoMasculina(5100000L);

        when(repository.findByAno(ano)).thenReturn(List.of(mortalidade));

        List<MortalidadeDto> result = mortalidadeService.consultarMortalidadePorAno(ano);

        assertEquals(1, result.size());
        assertEquals("BR", result.get(0).getCodPais());
        assertEquals(ano, result.get(0).getAno());
        assertEquals(valueOf(10.5), result.get(0).getTxFeminino());
        assertEquals(valueOf(9.8), result.get(0).getTxMasculino());
        verify(repository, times(1)).findByAno(ano);
    }

    @Test
    void testCriarRegistroMortalidade() {
        Long ano = 2022L;
        String pais = "BR";

        ResponseIne responseIne = new ResponseIne();
        responseIne.setTaxaMortalidadeFeminina(10.5);
        responseIne.setTaxaMortalidadeMasculina(9.8);
        responseIne.setObitoFeminino(1000L);
        responseIne.setObitoMasculino(1100L);

        Mortalidade mortalidade = new Mortalidade();
        mortalidade.setId(1L);
        mortalidade.setAno(ano);
        mortalidade.setCodPais(pais);

        Populacao populacao = new Populacao(5000000L, 5100000L);

        when(ine.getDadosIne(ano, pais)).thenReturn(responseIne);
        when(repository.save(any(Mortalidade.class))).thenReturn(mortalidade);

        mortalidadeService.criarRegistroMortalidade(ano, pais);

        verify(ine, times(1)).getDadosIne(ano, pais);
        verify(repository, times(1)).save(any(Mortalidade.class));
    }

}
