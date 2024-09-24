package com.livanio.mortalidade.repository;

import com.livanio.mortalidade.entity.Mortalidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MortalidadeRepository extends JpaRepository<Mortalidade, Long> {
    List<Mortalidade> findByAno(Long ano);

    Mortalidade findByAnoAndCodPais(Long ano, String codPais);
}
