package br.com.votacao.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_pauta")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pauta implements Serializable {
    private static final long serialVersionUID = 1433717283653371571L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pauta_sequence")
    @SequenceGenerator(name="pauta_sequence", sequenceName = "pauta_seq")
    @Column(name = "pauta_id", nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;
}