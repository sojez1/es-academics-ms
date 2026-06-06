package com.jpstechno.es_academic_ms.controlleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpstechno.es_academic_ms.securites.securitesServ;

@RestController
@RequestMapping("/authorizations")
public class Authorizations {

    @Autowired
    private securitesServ securitesServ;

    @GetMapping("/test")
    public String testAuthorization() {
        return securitesServ.testMicroServiceConnectivity();
    }

}
