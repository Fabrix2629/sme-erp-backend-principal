package proy.backend.proyClients.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.HttpHeaders;

import javax.naming.Name;

@OpenAPIDefinition(
        info = @Info(
                title = "SMC Sistema de mantenimiento de Clientes",
                description = "Sistema de manteniminetos de clientes CRUD básico",
                version = "1.0.0",
                contact = @Contact(
                        name = "Fabrisio Abdy Olivares Cuya",
                        email = "fabtisio123@gmail.com"
                ),
                license = @License(
                        name = "Standard Software Use License for Abdyvares"
                )
        ),
        servers = {
                @Server(
                        description = "DEV SERVER",
                        url = "http://localhost:8080"
                )
        },
        security= @SecurityRequirement(
                name= "Security Tocken"
        )
)
@SecurityScheme(
        name = "Security Tocken",
        description = "Acces Token For My API",
        type = SecuritySchemeType.HTTP,
        paramName = HttpHeaders.AUTHORIZATION,
        in = SecuritySchemeIn.HEADER,
        scheme = "bearer",
        bearerFormat = "JWT"


)
public class SwaggerConfig {
}
