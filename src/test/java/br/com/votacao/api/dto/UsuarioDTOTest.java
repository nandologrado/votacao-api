package br.com.votacao.api.dto;

import br.com.votacao.api.entity.Usuario;
import br.com.votacao.api.mock.UsuarioMocker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UsuarioDTOTest {

    @Test
    public void givenUsuario_whenValueOf_thenReturnUsuarioDTO() {
        Usuario usuarioMocker = UsuarioMocker.random().build();
        UsuarioDTO usuarioDTO = UsuarioDTO.valueOf(usuarioMocker);
        assertNotNull(usuarioDTO);
        assertEquals(usuarioMocker.getId(), usuarioDTO.getId());
        assertEquals(usuarioMocker.getNome(), usuarioDTO.getNome());
        assertEquals(usuarioMocker.getCpf(), usuarioDTO.getCpf());
    }

    @Test
    public void givenUsuarioDTO_whenToEntity_thenReturnUsuario() {
        UsuarioDTO usuarioDTOMocker = UsuarioMocker.DTO;
        Usuario usuario = usuarioDTOMocker.toEntity();
        assertNotNull(usuario);
        assertEquals(usuarioDTOMocker.getId(), usuario.getId());
        assertEquals(usuarioDTOMocker.getNome(), usuario.getNome());
        assertEquals(usuarioDTOMocker.getCpf(), usuario.getCpf());
    }
}
