package br.com.votacao.api.mock;

import br.com.votacao.api.dto.UsuarioDTO;
import br.com.votacao.api.entity.Usuario;
import br.com.votacao.api.utils.CpfUtils;

import java.util.Optional;

import static br.com.votacao.api.entity.Usuario.UsuarioBuilder;
import static br.com.votacao.api.entity.Usuario.builder;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class UsuarioMocker {
    private static UsuarioBuilder usuarioBuilder = builder();

    public UsuarioMocker() {
    }

    public static UsuarioBuilder random(){
        return usuarioBuilder
                .id(20L)
                .cpf(CpfUtils.geraCpf(false))
                .nome(randomAlphabetic(10));
    }

    public static final Optional<Usuario> ENTITY_OPTIONAL = Optional.of(UsuarioMocker.random().build());

    public static final UsuarioDTO DTO = UsuarioDTO.valueOf(UsuarioMocker.random().build());
}
