package com.itia.sitevitrine.exceptions;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ValidationExceptionObject {
    private String message;
    private Map<String, String> errors;
}