package com.livanio.mortalidade.service;

import com.livanio.mortalidade.dto.MortalidadeDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.io.IOException;
import java.util.List;

public interface MortalidadeService {
    List<MortalidadeDto> consultarMortalidadePorAno(Long ano) throws ChangeSetPersister.NotFoundException;
    void criarRegistroMortalidade(Long ano, String pais) throws ChangeSetPersister.NotFoundException;
    MortalidadeDto atualizarRegistroMortalidade(Long ano, String codPais, MortalidadeDto request) throws ChangeSetPersister.NotFoundException;
    void uploadDadosMortalidade(String path) throws IOException;
}
