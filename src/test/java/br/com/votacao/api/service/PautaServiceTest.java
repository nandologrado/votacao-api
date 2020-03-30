package br.com.votacao.api.service;

import br.com.votacao.api.dto.PautaDTO;
import br.com.votacao.api.entity.Pauta;
import br.com.votacao.api.mock.PautaMocker;
import br.com.votacao.api.repository.PautaRepository;
import br.com.votacao.api.repository.SessaoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class PautaServiceTest {
    @InjectMocks
    private PautaService service;

    @Mock
    private PautaRepository repository;

    @Mock
    private SessaoRepository sessaoRepository;

    @Before
    public void setUp() {
    }

    @Test
    public void whenFindAll_thenCallRepositoryOnce() {
        service.findAll();
        verify(repository, times(1)).findAll();
    }

    @Test
    public void givenPautaId_whenFindById_thenCallRepositoryOnce() {
        Pauta pautaMocker = PautaMocker.random().build();
        when(repository.findById(pautaMocker.getId())).thenReturn(Optional.of(pautaMocker));
        service.findById(pautaMocker.getId());
        verify(repository, times(1)).findById(pautaMocker.getId());
    }

    @Test
    public void givenPauta_whenSave_thenCallRepositoryAndReturnPauta() {
        PautaDTO pautaDTOMocker = PautaMocker.DTO;
        when(repository.save(pautaDTOMocker.toEntity())).thenReturn(pautaDTOMocker.toEntity());
        Pauta save = service.save(pautaDTOMocker);
        assertNotNull(save);
    }

    @Test
    public void givenPautaId_whenDelete_thenCallRepositoryOnceAndPollSessionRepositoryOnce() {
        Pauta pautaMocker = PautaMocker.random().build();
        when(repository.findById(pautaMocker.getId())).thenReturn(Optional.of(pautaMocker));
        service.deleteById(pautaMocker.getId());
        verify(repository, times(1)).delete(pautaMocker);
        verify(sessaoRepository, times(1)).findByPautaId(pautaMocker.getId());
    }
}
