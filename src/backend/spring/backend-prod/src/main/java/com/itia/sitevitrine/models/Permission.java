package com.itia.sitevitrine.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    JOBER_READ("jober:read"),
    JOBER_UPDATE("jober:update"),
    JOBER_CREATE("jober:create"),
    JOBER_DELETE("jober:delete"),
    ENTERPRISE_READ("enterprise:read"),
    ENTERPRISE_UPDATE("enterprise:update"),
    ENTERPRISE_CREATE("enterprise:create"),
    ENTERPRISE_DELETE("enterprise:delete");

    private final String permission;
}
