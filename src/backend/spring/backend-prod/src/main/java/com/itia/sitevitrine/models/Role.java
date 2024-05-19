package com.itia.sitevitrine.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import static com.itia.sitevitrine.models.Permission.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public enum Role {
        USER(Collections.emptySet()),
        ADMIN(
                        Set.of(
                                        ADMIN_READ,
                                        ADMIN_UPDATE,
                                        ADMIN_DELETE,
                                        ADMIN_CREATE,
                                        JOBER_READ,
                                        JOBER_UPDATE,
                                        JOBER_DELETE,
                                        JOBER_CREATE)),
        JOBER(
                        Set.of(
                                        JOBER_READ,
                                        JOBER_UPDATE,
                                        JOBER_DELETE,
                                        JOBER_CREATE)),
        ENTERPRISE(
                        Set.of(
                                        ENTERPRISE_READ,
                                        ENTERPRISE_UPDATE,
                                        ENTERPRISE_DELETE,
                                        ENTERPRISE_CREATE));

        private final Set<Permission> permissions;

        public List<SimpleGrantedAuthority> getAuthorities() {
                List<SimpleGrantedAuthority> authorities = new java.util.ArrayList<>(
                                getPermissions()
                                                .stream()
                                                .map(permission -> new SimpleGrantedAuthority(
                                                                permission.getPermission()))
                                                .toList());

                authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

                return authorities;
        }
}
