package br.com.votacao.api.mock;

import br.com.votacao.api.dto.VotacaoDTO;
import br.com.votacao.api.entity.Sessao;
import br.com.votacao.api.entity.Usuario;
import br.com.votacao.api.entity.Votacao;
import br.com.votacao.api.model.VotoEnum;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import static br.com.votacao.api.entity.Votacao.VotacaoBuilder;
import static br.com.votacao.api.entity.Votacao.builder;

public class VotacaoMocker {

    private static VotacaoBuilder votacaoBuilder = builder();

    public VotacaoMocker() {
    }

    public static VotacaoBuilder random(){
        return votacaoBuilder
                .usuario(Usuario.builder().build())
                .sessao(Sessao.builder().build())
                .data(LocalDateTime.now())
                .voto(VotoEnum.values()[new Random().nextInt(VotoEnum.values().length-1)]);
    }

    public static final Optional<Votacao> ENTITY_OPTIONAL = Optional.of(VotacaoMocker.random().build());

    public static final VotacaoDTO DTO = VotacaoDTO.valueOf(VotacaoMocker.random().build());
}
