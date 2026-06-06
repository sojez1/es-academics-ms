package com.jpstechno.es_academic_ms.securites;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpstechno.es_academic_ms.feign.AuthenticationInterface;

@Service
public class securitesServ {

    @Autowired
    AuthenticationInterface authClient;

    public String testMicroServiceConnectivity() {
        return authClient.loginTest();
    }

}
