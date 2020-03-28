package br.com.votacao.api.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
public class SessaoRequestDTO implements Serializable {

    private static final long serialVersionUID = 8321599816812740440L;

    @NotNull(message = "{sessao.pauta.notempty}")
    private Long pautaId;

    private Integer duracaoSessao;
}
