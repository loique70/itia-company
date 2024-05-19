package com.itia.sitevitrine.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import java.util.List;

import com.itia.sitevitrine.beans.User;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends EntityBaseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private String rolesString;
    private List<Role> roles;
    private List<TokenDTO> tokens;

    public UserDTO(User user) {
        this.id = user.getId();
        this.createdOn = user.getCreatedOn();
        this.lastUpdateOn = user.getLastUpdateOn();

        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.rolesString = user.getRolesString();

        this.roles = user.getRoles();
        this.tokens = user.getTokensDTO();
    }
}
