package br.com.votacao.api.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class SessaoResultadoDTO  implements Serializable {

    private static final long serialVersionUID = 4597624288628165397L;

    private PautaDTO pautaDTO;
    private Long durationMinutes;
    private SessaoResultadoVotosDTO sessaoResultadoVotosDTO;

}
