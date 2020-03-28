package br.com.votacao.api.dto;

import br.com.votacao.api.entity.Votacao;
import br.com.votacao.api.model.VotoEnum;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class VotacaoDTO  implements Serializable {

    private static final long serialVersionUID = 960840275974345345L;

    private Long sessaoId;
    private Long usuarioId;
    private VotoEnum vote;

    public static VotacaoDTO valueOf(Votacao votacao) {
        return VotacaoDTO.builder()
                .sessaoId(votacao.getSessao().getId())
                .usuarioId(votacao.getUsuario().getId())
                .vote(votacao.getVoto())
                .build();
    }
}
