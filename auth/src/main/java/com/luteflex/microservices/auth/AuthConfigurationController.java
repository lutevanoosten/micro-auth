package com.luteflex.microservices.auth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthConfigurationController {

    @GetMapping("/createJwt")
    public AuthConfiguration retriveLimitsFromConfigurations()
    {
        return new AuthConfiguration(1000, 1);
    }
}