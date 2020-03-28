package br.com.votacao.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="tb_sessao")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sessao implements Serializable {
    private static final long serialVersionUID = 2090055817682204157L;

    @Id
    @Column(name = "sessao_id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sessao_sequence")
    @SequenceGenerator(name="sessao_sequence", sequenceName = "sessao_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pauta_id")
    private Pauta pauta;

    @Column(nullable = false)
    private LocalDateTime dataInicio;

    @Column(nullable = false)
    private LocalDateTime dataFim;

}