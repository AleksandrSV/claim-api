package ru.rowi.util;

import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class TokenUtil {
    public String getUsername(KeycloakAuthenticationToken token){
        return token.getAccount().getKeycloakSecurityContext().getToken().getPreferredUsername();
    }
}
