package com.livanio.mortalidade.client;

import com.livanio.mortalidade.dto.ResponseIne;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "mortalidadeService", url = "${feign.client.config.ine.url}")
public interface IneMockClient {

    @GetMapping
    ResponseIne getDadosIne(@RequestParam("ano") Long ano, @RequestParam("pais") String pais);
}
