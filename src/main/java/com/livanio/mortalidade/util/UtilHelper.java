package com.livanio.mortalidade.util;

import com.livanio.mortalidade.dto.Populacao;

import java.math.BigDecimal;
import java.math.MathContext;

public class UtilHelper {

    public static Populacao calculaPopulacao(Long obitM, Long obitF, BigDecimal taxObtF, BigDecimal taxObtM){

        var populacao = new Populacao();

        var popMasculina = (BigDecimal.valueOf(obitM)).divide(taxObtM, 2)
                .multiply(new BigDecimal(1000));
        var popfeminina = (BigDecimal.valueOf(obitF).divide(taxObtF, 2))
                .multiply(new BigDecimal(1000));
        populacao.setPopulacaoFeminina(popfeminina.longValue());
        populacao.setPopulacaoMasculina(popMasculina.longValue());

        return populacao;

    }
}
