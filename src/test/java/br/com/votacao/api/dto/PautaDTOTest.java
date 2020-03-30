package br.com.votacao.api.dto;

import br.com.votacao.api.entity.Pauta;
import br.com.votacao.api.mock.PautaMocker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PautaDTOTest {

    @Test
    public void givenPauta_whenValueOf_thenReturnPautaDTO() {
        Pauta pautaMocker = PautaMocker.random().build();
        PautaDTO pautaDTO = PautaDTO.valueOf(pautaMocker);
        assertNotNull(pautaDTO);
        assertEquals(pautaMocker.getId(), pautaDTO.getId());
        assertEquals(pautaMocker.getNome(), pautaDTO.getNome());
        assertEquals(pautaMocker.getDescricao(), pautaDTO.getDescricao());
    }

    @Test
    public void givenPautaDTO_whenToEntity_thenReturnPauta() {
        PautaDTO pautaDTOMocker = PautaMocker.DTO;
        Pauta pauta = pautaDTOMocker.toEntity();
        assertNotNull(pauta);
        assertEquals(pautaDTOMocker.getId(), pauta.getId());
        assertEquals(pautaDTOMocker.getNome(), pauta.getNome());
        assertEquals(pautaDTOMocker.getDescricao(), pauta.getDescricao());
    }

}
