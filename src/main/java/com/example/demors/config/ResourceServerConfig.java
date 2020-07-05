package com.example.demors.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig {

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(converter());
    }

    @Bean
    public JwtAccessTokenConverter converter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();

        //It is not encrypted , just signed in.Then the resource server valid this with this signing key.
        jwtAccessTokenConverter.setSigningKey("secret");
        return jwtAccessTokenConverter;
    }


}
