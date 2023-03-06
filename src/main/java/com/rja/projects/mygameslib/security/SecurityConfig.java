package com.rja.projects.mygameslib.security;

import com.c4_soft.springaddons.security.oauth2.OAuthentication;
import com.c4_soft.springaddons.security.oauth2.OpenidClaimSet;
import com.c4_soft.springaddons.security.oauth2.config.synchronised.OAuth2AuthenticationFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    OAuth2AuthenticationFactory authenticationFactory(Converter<Map<String, Object>, Collection<? extends GrantedAuthority>> authoritiesConverter) {
        return (bearerString, claims) -> new OAuthentication<>(new OpenidClaimSet(claims),
                authoritiesConverter.convert(claims), bearerString);
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers("/swagger-ui/","/swagger-ui/**", "/api-docs/**");
    }


}
