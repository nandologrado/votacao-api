package br.com.votacao.api.dto;

import br.com.votacao.api.entity.Sessao;
import br.com.votacao.api.mock.SessaoMocker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SessaoDTOTest {

    @Test
    public void givenSessao_whenValueOf_thenReturnSessaoDTO() {
        Sessao sessaoMocker = SessaoMocker.random().build();
        SessaoDTO sessaoDTO = SessaoDTO.valueOf(sessaoMocker);
        assertNotNull(sessaoDTO);
        assertEquals(sessaoMocker.getId(), sessaoDTO.getId());
        assertEquals(sessaoMocker.getPauta(), sessaoDTO.getPautaDTO().toEntity());
        assertEquals(sessaoMocker.getDataInicio(), sessaoDTO.getDataInicio());

    }

}
