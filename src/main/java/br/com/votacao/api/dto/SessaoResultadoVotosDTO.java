package br.com.votacao.api.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class SessaoResultadoVotosDTO  implements Serializable {

    private static final long serialVersionUID = 7437880471622910575L;

    private int totalVotos;
    private int totalSimVotos;
    private int totalNaoVotos;

}
