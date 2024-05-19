package com.itia.sitevitrine.models;

import java.io.Serializable;

import com.itia.sitevitrine.beans.Token;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO extends EntityBaseDTO implements Serializable {
    private String token;
    private TokenType tokenType;
    private boolean expired;
    private boolean revoked;

    private UserDTO user;

    public TokenDTO(Token token) {
        this.id = token.getId();
        this.createdOn = token.getCreatedOn();
        this.lastUpdateOn = token.getLastUpdateOn();

        this.token = token.getToken();
        this.tokenType = token.getTokenType();
        this.expired = token.isExpired();
        this.revoked = token.isRevoked();

        if (token.getUser() != null)
            this.user = new UserDTO(token.getUser());
    }
}
