package com.livanio.mortalidade.dto;

import com.livanio.mortalidade.entity.Mortalidade;

import java.math.BigDecimal;

public class MortalidadeDto {
    private Long id;
    private String codPais;
    private BigDecimal txFeminino;
    private BigDecimal txMasculino;
    private Long ano;
    private Long populacaoMasculina;
    private Long populacaoFeminina;

    public MortalidadeDto(Long id,String codPais, BigDecimal txFeminino, BigDecimal txMasculino,
                          Long ano, Long populacaoMasculina, Long populacaoFeminina) {
        this.id = id;
        this.codPais = codPais;
        this.txFeminino = txFeminino;
        this.txMasculino = txMasculino;
        this.ano = ano;
        this.populacaoFeminina = populacaoFeminina;
        this.populacaoMasculina = populacaoMasculina;
    }

    public MortalidadeDto(Mortalidade mortalidade) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPopulacaoMasculina() {
        return populacaoMasculina;
    }

    public void setPopulacaoMasculina(Long populacaoMasculina) {
        this.populacaoMasculina = populacaoMasculina;
    }

    public Long getPopulacaoFeminina() {
        return populacaoFeminina;
    }

    public void setPopulacaoFeminina(Long populacaoFeminina) {
        this.populacaoFeminina = populacaoFeminina;
    }

    public MortalidadeDto() {
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public BigDecimal getTxFeminino() {
        return txFeminino;
    }

    public void setTxFeminino(BigDecimal txFeminino) {
        this.txFeminino = txFeminino;
    }

    public BigDecimal getTxMasculino() {
        return txMasculino;
    }

    public void setTxMasculino(BigDecimal txMasculino) {
        this.txMasculino = txMasculino;
    }

    public Long getAno() {
        return ano;
    }

    public void setAno(Long ano) {
        this.ano = ano;
    }
}
