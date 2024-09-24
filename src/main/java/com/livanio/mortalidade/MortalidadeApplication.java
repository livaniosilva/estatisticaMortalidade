package com.livanio.mortalidade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class MortalidadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MortalidadeApplication.class, args);
	}

}
