package com.itia.sitevitrine.models;

import java.util.List;

public record RegisterRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        List<Role> roles) {
}
