package br.com.teams.server.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NotificacaoMapper {

    public Map<String, String> notificaoExemploMapper(String mensagem, String status){

        Map<String, String> params = new HashMap<>();

        params.put("mensagem", mensagem);
        params.put("status", status);

        return params;
    }
}
