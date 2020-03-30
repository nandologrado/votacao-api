package br.com.votacao.api.mock;

import br.com.votacao.api.dto.PautaDTO;
import br.com.votacao.api.entity.Pauta;

import java.util.Optional;

import static br.com.votacao.api.entity.Pauta.PautaBuilder;
import static br.com.votacao.api.entity.Pauta.builder;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class PautaMocker {

    private static PautaBuilder pautaBuilder = builder();

    public PautaMocker() {
    }

    public static PautaBuilder random(){
        return pautaBuilder
                .id(40L)
                .nome(randomAlphabetic(10))
                .descricao(randomAlphabetic(15));
    }

    public static final Optional<Pauta> ENTITY_OPTIONAL = Optional.of(PautaMocker.random().build());

    public static final PautaDTO DTO = PautaDTO.valueOf(PautaMocker.random().build());

}
