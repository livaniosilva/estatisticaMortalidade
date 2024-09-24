package com.livanio.mortalidade.controller;

import com.livanio.mortalidade.service.MortalidadeService;
import com.livanio.mortalidade.dto.MortalidadeDto;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("mortalidades")
public  class MortalidadeController {
    private final MortalidadeService mortalidadeService;

    public MortalidadeController(MortalidadeService mortalidadeService) {
        this.mortalidadeService = mortalidadeService;
    }

    @GetMapping("/por-ano")
    public List<MortalidadeDto> consultarMortalidadePorAno(@RequestParam("ano") Long ano) throws ChangeSetPersister.NotFoundException {
        return mortalidadeService.consultarMortalidadePorAno(ano);
    }

    @PostMapping
    public void criarRegistroMortalidadeAnoPais(@RequestParam("ano") Long ano,
                                                          @RequestParam("codPais") String codPais) throws ChangeSetPersister.NotFoundException {
         mortalidadeService.criarRegistroMortalidade(ano, codPais);
    }

    @PutMapping
    public MortalidadeDto atualizarRegistroMortalidadeAnoPais(@RequestParam("ano") Long ano,
                                                              @RequestParam("codPais") String codPais,
                                                              @RequestBody MortalidadeDto request) throws ChangeSetPersister.NotFoundException {
        return mortalidadeService.atualizarRegistroMortalidade(ano, codPais, request);
    }

    @PostMapping("/upload-registros-mortalidades")
    public void upLoadRegistroMortalidade(@RequestParam("file") String file) throws IOException {

        mortalidadeService.uploadDadosMortalidade(file);
    }

    public MortalidadeService mortalidadeService() {
        return mortalidadeService;
    }


}
