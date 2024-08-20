package org.example.gatewayserver.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KeycloakAuthorityConverter implements Converter<Jwt, Collection<GrantedAuthority>>{

    @Override
    public Collection<GrantedAuthority> convert(Jwt source) {
       String realmAccess = (String)source.getClaims().get("scope");
       if (StringUtils.isEmpty(realmAccess)) {
           return new ArrayList<>();
       }

       String[] authoritiesArray = realmAccess.split(" ");
         Collection<GrantedAuthority> authorities = Stream.of(authoritiesArray)
//                 .map(authority -> authority)
                 .map(SimpleGrantedAuthority::new)
                 .collect(Collectors.toList());

            return authorities;
    }
}
