package com.livanio.mortalidade.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class ResponseIne {
    private Long ano;
    @JsonProperty("obito_feminino")
    private Long obitoFeminino;
    @JsonProperty("obito_masculino")
    private Long obitoMasculino;
    @JsonProperty("tax_mortalidade_feminina")
    private double taxaMortalidadeFeminina;
    @JsonProperty("tax_mortalidade_masculina")
    private double taxaMortalidadeMasculina;
    private String pais;

    public ResponseIne(Long ano, Long obitoFeminino, Long obitoMasculino,
                       double taxaMortalidadeFeminina, double taxaMortalidadeMasculina, String pais) {
        this.ano = ano;
        this.obitoFeminino = obitoFeminino;
        this.obitoMasculino = obitoMasculino;
        this.taxaMortalidadeFeminina = taxaMortalidadeFeminina;
        this.taxaMortalidadeMasculina = taxaMortalidadeMasculina;
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Long getAno() {
        return ano;
    }

    public void setAno(Long ano) {
        this.ano = ano;
    }

    public Long getObitoFeminino() {
        return obitoFeminino;
    }

    public void setObitoFeminino(Long obitoFeminino) {
        this.obitoFeminino = obitoFeminino;
    }

    public Long getObitoMasculino() {
        return obitoMasculino;
    }

    public void setObitoMasculino(Long obitoMasculino) {
        this.obitoMasculino = obitoMasculino;
    }

    public double getTaxaMortalidadeFeminina() {
        return taxaMortalidadeFeminina;
    }

    public void setTaxaMortalidadeFeminina(double taxaMortalidadeFeminina) {
        this.taxaMortalidadeFeminina = taxaMortalidadeFeminina;
    }

    public double getTaxaMortalidadeMasculina() {
        return taxaMortalidadeMasculina;
    }

    public void setTaxaMortalidadeMasculina(double taxaMortalidadeMasculina) {
        this.taxaMortalidadeMasculina = taxaMortalidadeMasculina;
    }
}
