package br.com.votacao.api.dto;

import br.com.votacao.api.entity.Pauta;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class PautaDTO implements Serializable {

    private static final long serialVersionUID = -5463577171309546021L;

    private Long id;
     private String nome;
     private String descricao;

    public static PautaDTO valueOf(Pauta pauta) {
        return PautaDTO.builder()
                .id(pauta.getId())
                .nome(pauta.getNome())
                .descricao(pauta.getDescricao())
                .build();
    }

    public Pauta toEntity() {
        return Pauta.builder()
                .id(this.id)
                .nome(this.nome)
                .descricao(this.descricao)
                .build();
    }

}
