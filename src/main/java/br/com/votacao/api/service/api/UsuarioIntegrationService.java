package br.com.votacao.api.service.api;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UsuarioIntegrationService {

    private final String URL_SERVICE = "https://user-info.herokuapp.com/users/";

    public String aptoVotacao (String cpf){

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(URL_SERVICE+cpf, String.class);
        return response;
    }

}
