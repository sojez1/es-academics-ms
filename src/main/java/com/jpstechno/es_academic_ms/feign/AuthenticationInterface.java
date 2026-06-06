package com.jpstechno.es_academic_ms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "es-auth-ms", path = "/easyschool/auth")
public interface AuthenticationInterface {

    @GetMapping("/authentifier/logtest")
    public String loginTest();

}
