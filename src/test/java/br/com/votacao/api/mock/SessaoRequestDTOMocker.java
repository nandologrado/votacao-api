package br.com.votacao.api.mock;

import static br.com.votacao.api.dto.SessaoRequestDTO.SessaoRequestDTOBuilder;
import static br.com.votacao.api.dto.SessaoRequestDTO.builder;

public class SessaoRequestDTOMocker {

    private static SessaoRequestDTOBuilder sessaoRequestDTOBuilder = builder();

    public static final int DURATION = 3600;

    public SessaoRequestDTOMocker() {
    }

    public static SessaoRequestDTOBuilder random(){
        return sessaoRequestDTOBuilder
                .pautaId(PautaMocker.random().build().getId())
                .duracaoSessao(3600);
    }

}
