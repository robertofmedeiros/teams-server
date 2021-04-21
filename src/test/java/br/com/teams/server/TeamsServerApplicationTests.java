package br.com.teams.server;

import br.com.teams.server.services.NotificacaoProperties;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TeamsServerApplicationTests {

	@Autowired
	private NotificacaoProperties notificacaoProperties;

	@Autowired
	private Configuration cfg;

	@Autowired
	private RestTemplate restTemplate;

	@Test
	void contextLoads() throws IOException, TemplateException {

		Template template = cfg.getTemplate("notificacao_teams.ftl");

		Map<String, String> params = new HashMap<>();
		params.put("mensagem", "Se receber essa mensagem, está tudo ok");
		params.put("status", "envio_teste");

		StringWriter out = new StringWriter();

		template.process(params, out);

		restTemplate.postForLocation(notificacaoProperties.getWebhook(), out.toString());

//		System.out.println(template.toString());
	}

}
