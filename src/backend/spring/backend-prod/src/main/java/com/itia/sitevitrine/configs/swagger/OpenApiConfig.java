package com.itia.sitevitrine.configs.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(contact = @Contact(name = "Basile Fofack", email = "juniorbasilefofack@gmail.com", url = "http://localhost:8081"), description = "OpenAPI Documentation for Spring Security", title = "OpenAPI Specification", license = @License(url = "https://something.com", name = "MIT"), version = "1.0"), servers = {
        @Server(url = "http://localhost:8081", description = "Local Env"),
        @Server(url = "http://localhost:8081", description = "Prod Env")
}, security = {
        @SecurityRequirement(name = "bearerAuth")
})
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER, description = "JWT auth description", scheme = "bearer", bearerFormat = "JWT")
public class OpenApiConfig {
}
