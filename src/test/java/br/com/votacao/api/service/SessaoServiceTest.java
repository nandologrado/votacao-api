package br.com.votacao.api.service;

import br.com.votacao.api.entity.Sessao;
import br.com.votacao.api.mock.PautaMocker;
import br.com.votacao.api.mock.SessaoMocker;
import br.com.votacao.api.mock.SessaoRequestDTOMocker;
import br.com.votacao.api.repository.SessaoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class SessaoServiceTest {

    @InjectMocks
    private SessaoService service;

    @Mock
    private SessaoRepository repository;

    @Mock
    private PautaService pollService;

    @Before
    public void setUp() {
    }

    @Test
    public void givenSessaoId_whenFindById_thenCallRepositoryOnce() {
        Sessao sessaoMocker = SessaoMocker.random().build();
        when(repository.findById(sessaoMocker.getId())).thenReturn(Optional.of(sessaoMocker));
        service.findById(sessaoMocker.getId());
        verify(repository, times(1)).findById(sessaoMocker.getId());
    }

    @Test
    public void givenPautaId_whenFindByPautaId_thenCallRepositoryOnce() {
        when(repository.findByPautaId(PautaMocker.random().build().getId())).thenReturn(SessaoMocker.LIST);
        service.findByPauta(PautaMocker.random().build().getId());
    }

    @Test
    public void givenSessao_whenSave_thenCallRepositoryAndReturnSessao() {
        when(repository.save(any(Sessao.class))).thenReturn(SessaoMocker.random().build());
        Sessao save = service.save(SessaoRequestDTOMocker.random().build());
        assertNotNull(save);
    }
}
