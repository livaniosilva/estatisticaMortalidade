package com.livanio.mortalidade.dto;

/**
 * Problema com Lombok, por isso geracao dos getters e setters com construtores na mão
 */
public class Populacao {
    private Long populacaoTotal;
    private Long populacaoFeminina;
    private Long populacaoMasculina;


    public Populacao(Long populacaoTotal, Long populacaoFeminina, Long populacaoMasculina) {
        this.populacaoTotal = populacaoTotal;
        this.populacaoFeminina = populacaoFeminina;
        this.populacaoMasculina = populacaoMasculina;
    }

    public Populacao() {
    }

    public Long getPopulacaoTotal() {
        return populacaoTotal;
    }

    public void setPopulacaoTotal(Long populacaoTotal) {
        this.populacaoTotal = populacaoTotal;
    }

    public Long getPopulacaoFeminina() {
        return populacaoFeminina;
    }

    public void setPopulacaoFeminina(Long populacaoFeminina) {
        this.populacaoFeminina = populacaoFeminina;
    }

    public Long getPopulacaoMasculina() {
        return populacaoMasculina;
    }

    public void setPopulacaoMasculina(Long populacaoMasculina) {
        this.populacaoMasculina = populacaoMasculina;
    }
}
