package br.com.teams.server.services;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix="teams")
public class NotificacaoProperties {
    private String webhook;
}
