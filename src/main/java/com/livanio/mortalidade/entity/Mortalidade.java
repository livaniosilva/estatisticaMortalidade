package com.livanio.mortalidade.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
@Table
public class Mortalidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private  Long id;
    @Column(name = "codPais", nullable = false)
    private  String codPais;
    @Column(name = "txFeminino", nullable = false)
    private  BigDecimal txFeminino;
    @Column(name = "txMasculino", nullable = false)
    private  BigDecimal txMasculino;
    @Column(name = "ano", nullable = false)
    private  Long ano;
    @Column(name = "pupulacaoMasculina", nullable = false)
    private  Long pupulacaoMasculina;
    @Column(name = "populacaoFeminina", nullable = false)



    private  Long populacaoFeminina;

    public Long getPupulacaoMasculina() {
        return pupulacaoMasculina;
    }

    public void setPupulacaoMasculina(Long pupulacaoMasculina) {
        this.pupulacaoMasculina = pupulacaoMasculina;
    }

    public Long getPopulacaoFeminina() {
        return populacaoFeminina;
    }

    public void setPopulacaoFeminina(Long populacaoFeminina) {
        this.populacaoFeminina = populacaoFeminina;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Mortalidade() {

    }

    public Mortalidade(Long id, String codPais, BigDecimal txFeminino, BigDecimal txMasculino, Long ano, Long pupulacaoMasculina, Long populacaoFeminina) {
        this.id = id;
        this.codPais = codPais;
        this.txFeminino = txFeminino;
        this.txMasculino = txMasculino;
        this.ano = ano;
        this.pupulacaoMasculina = pupulacaoMasculina;
        this.populacaoFeminina = populacaoFeminina;
    }
}
