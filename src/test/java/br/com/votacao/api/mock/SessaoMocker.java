package br.com.votacao.api.mock;

import br.com.votacao.api.dto.SessaoDTO;
import br.com.votacao.api.entity.Sessao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static br.com.votacao.api.entity.Sessao.SessaoBuilder;
import static br.com.votacao.api.entity.Sessao.builder;
import static java.util.Collections.singletonList;

public class SessaoMocker {

    private static SessaoBuilder sessaoBuilder = builder();

    public SessaoMocker() {
    }

    public static SessaoBuilder random(){
        return sessaoBuilder
                .id(30L)
                .pauta(PautaMocker.random().build())
                .dataInicio(LocalDateTime.now())
                .dataFim(LocalDateTime.now().plusSeconds(60));
    }

    public static SessaoBuilder randomExpirado(){
        return sessaoBuilder
                .id(30L)
                .pauta(PautaMocker.random().build())
                .dataInicio(LocalDateTime.now().minusMinutes(2))
                .dataFim(LocalDateTime.now().plusSeconds(1));
    }

    public static final SessaoDTO DTO = SessaoDTO.valueOf(SessaoMocker.random().build());

    public static final Optional<Sessao> ENTITY_OPTIONAL = Optional.of(SessaoMocker.random().build());

    public static final List<Sessao> LIST = singletonList(SessaoMocker.random().build());

    public static final List<Sessao> EMPTY_LIST = new ArrayList<>();

}
