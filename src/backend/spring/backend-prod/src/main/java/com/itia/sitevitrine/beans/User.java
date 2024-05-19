package com.itia.sitevitrine.beans;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.itia.sitevitrine.models.Role;
import com.itia.sitevitrine.models.TokenDTO;
import com.itia.sitevitrine.models.UserDTO;
import com.itia.sitevitrine.utils.JsonSerializer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User extends EntityBase implements UserDetails {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Lob
    @Column(name = "roles")
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String rolesString;

    @Transient
    @Setter(AccessLevel.NONE)
    private List<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    public User(Long id) {
        super(id);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (roles != null) {
            List<SimpleGrantedAuthority> authorities = roles.stream()
                    .flatMap(role -> role.getAuthorities().stream())
                    .distinct()
                    .collect(Collectors.toList());
            return authorities;
        }
        return new ArrayList<>();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.createdOn = userDTO.getCreatedOn();
        this.lastUpdateOn = userDTO.getLastUpdateOn();

        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.roles = userDTO.getRoles();
    }

    public List<TokenDTO> getTokensDTO() {
        return this.tokens != null
                ? this.tokens.stream().map(TokenDTO::new).collect(Collectors.toList())
                : new ArrayList<>();
    }

    public static UserDTO fromUser(User user) {
        return new UserDTO(user);
    }

    public static User toUser(UserDTO userDTO) {
        return new User(userDTO);
    }

    public String getRolesString() {
        this.rolesObjectFromJSON();
        return rolesString;
    }

    public void setRolesString(String rolesString) {
        this.rolesString = rolesString;
        this.rolesObjectFromJSON();
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
        this.rolesJSONFromObject();
    }

    private void rolesObjectFromJSON() {
        if (this.rolesString != null && !this.rolesString.isBlank())
            this.roles = JsonSerializer.fromJson(this.rolesString, new ParameterizedTypeReference<List<Role>>() {
            });
    }

    private void rolesJSONFromObject() {
        this.rolesString = JsonSerializer.toJson(this.roles);
    }
}
