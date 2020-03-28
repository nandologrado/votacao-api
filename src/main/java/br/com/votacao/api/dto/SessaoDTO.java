package br.com.votacao.api.dto;

import br.com.votacao.api.entity.Sessao;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class SessaoDTO implements Serializable {

    private static final long serialVersionUID = -3429846795653645357L;

    private Long id;
    private PautaDTO pautaDTO;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    public static SessaoDTO valueOf(Sessao sessao) {
        return SessaoDTO.builder()
                .id(sessao.getId())
                .pautaDTO(PautaDTO.valueOf(sessao.getPauta()))
                .dataInicio(sessao.getDataInicio())
                .dataFim(sessao.getDataFim())
                .build();
    }

}
