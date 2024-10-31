package com.contatos.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.contatos.model.Endereco;

// TODO: Auto-generated Javadoc
/**
 * The Class CepService.
 */
@Service
public class CepService {

    /**
     * Buscar endereco por cep.
     *
     * @param cep the cep
     * @return the endereco
     */
    public Endereco buscarEnderecoPorCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        RestTemplate restTemplate = new RestTemplate();
        Endereco endereco = restTemplate.getForObject(url, Endereco.class);

        if (endereco != null && endereco.getCep() != null) {
            return endereco;
        } else {
            return null;
        }
    }
}
