package br.com.votacao.api.service;

import br.com.votacao.api.entity.Usuario;
import br.com.votacao.api.mock.UsuarioMocker;
import br.com.votacao.api.repository.UsuarioRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService service;

    @Mock
    private UsuarioRepository repository;

    @Before
    public void setUp() {
    }

    @Test
    public void whenFindAll_thenCallRepositoryOnce() {
        service.findAll();
        verify(repository, times(1)).findAll();
    }

    @Test
    public void givenUsuarioId_whenFindById_thenCallRepositoryOnce() {
        Usuario usuarioMocker = UsuarioMocker.random().build();
        when(repository.findById(usuarioMocker.getId())).thenReturn(UsuarioMocker.ENTITY_OPTIONAL);
        service.findById(usuarioMocker.getId());
        verify(repository, times(1)).findById(usuarioMocker.getId());
    }

    @Test
    public void givenUsuario_whenSave_thenCallRepositoryAndReturnUsuario() {
        Usuario usuarioMocker = UsuarioMocker.random().build();
        when(repository.save(any(Usuario.class))).thenReturn(usuarioMocker);
        Usuario save = service.save(UsuarioMocker.DTO);
        assertNotNull(save);
    }
}
