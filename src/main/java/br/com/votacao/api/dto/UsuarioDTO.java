package br.com.votacao.api.dto;

import br.com.votacao.api.entity.Usuario;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = -976994275690738539L;

    private Long id;

    private String nome;

    private String cpf;

    public static UsuarioDTO valueOf(Usuario user) {
        return UsuarioDTO.builder()
                .id(user.getId())
                .nome(user.getNome())
                .cpf(user.getCpf())
                .build();
    }

    public Usuario toEntity() {
        return Usuario.builder()
                .id(this.id)
                .nome(this.nome)
                .cpf(this.cpf)
                .build();
    }
}
