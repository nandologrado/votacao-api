package br.com.votacao.api.votacao.entity;

import br.com.votacao.api.votacao.model.VotoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="tb_votacao")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Votacao implements Serializable {

    private static final long serialVersionUID = 4758228286819587830L;

    @EmbeddedId
    VotacaoPK id;

    @ManyToOne
    @MapsId("sessao_id")
    @JoinColumn(name = "sessao_id")
    private Sessao sessao;

    @ManyToOne
    @MapsId("usuario_id")
    @JoinColumn(name = "usuario_id")
    private Usuario user;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VotoEnum voto;
}
