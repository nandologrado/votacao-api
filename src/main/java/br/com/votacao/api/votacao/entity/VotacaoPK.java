package br.com.votacao.api.votacao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VotacaoPK implements Serializable {

    private static final long serialVersionUID = 2077500453524661335L;

    @Column(name = "sessao_id", nullable = false)
    Long sessaoId;

    @Column(name = "usuario_id", nullable = false)
    Long usuarioId;
}
