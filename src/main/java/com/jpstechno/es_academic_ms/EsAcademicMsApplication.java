package com.jpstechno.es_academic_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EsAcademicMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsAcademicMsApplication.class, args);
	}

}
