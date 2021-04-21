package br.com.teams.server.services;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.StringWriter;

@Service
@Slf4j
public class NotificacaoService {

    @Autowired
    private NotificacaoProperties notificacaoProperties;

    @Autowired
    private Configuration cfg;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NotificacaoMapper notificacaoMapper;

    public void enviarNotificacaoExemplo(String mensagem, String status){
        try {

            log.warn("Carregando Template");
            Template template = cfg.getTemplate("notificacao_teams.ftl");

            StringWriter out = new StringWriter();

            log.warn("Fazendo parse dos paramentros da template");
            template.process(notificacaoMapper.notificaoExemploMapper(mensagem, status), out);

            log.warn("Enviando json para o teams");
            restTemplate.postForLocation(notificacaoProperties.getWebhook(), out.toString());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Erro ao gerar notificação para o teams, mensagem: {}", e.getLocalizedMessage());
        }
    }
}
