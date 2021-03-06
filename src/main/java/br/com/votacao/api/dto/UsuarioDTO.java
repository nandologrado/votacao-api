package br.com.votacao.api.dto;

import br.com.votacao.api.entity.Usuario;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = -976994275690738539L;

    private Long id;

    @NotNull(message = "{usuario.nome.notempty}")
    private String nome;

    @NotNull(message = "{usuario.cpf.notempty}")
    private String cpf;

    public static UsuarioDTO valueOf(Usuario usuario) {
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .cpf(usuario.getCpf())
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
