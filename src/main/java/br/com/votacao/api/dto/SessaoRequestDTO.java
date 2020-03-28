package br.com.votacao.api.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class SessaoRequestDTO implements Serializable {

    private static final long serialVersionUID = 8321599816812740440L;

    private Long pautaId;

    private Integer duracaoSessao;
}
