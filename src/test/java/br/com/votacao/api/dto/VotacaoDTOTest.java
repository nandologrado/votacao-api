package br.com.votacao.api.dto;

import br.com.votacao.api.entity.Votacao;
import br.com.votacao.api.mock.VotacaoMocker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class VotacaoDTOTest {
    @Test
    public void givenPauta_whenValueOf_thenReturnPautaDTO() {
        Votacao votacaoMocker = VotacaoMocker.random().build();
        VotacaoDTO votacaoDTO = VotacaoDTO.valueOf(votacaoMocker);
        assertNotNull(votacaoDTO);
        assertEquals(votacaoMocker.getSessao().getId(), votacaoDTO.getSessaoId());
        assertEquals(votacaoMocker.getUsuario().getId(), votacaoDTO.getUsuarioId());
        assertEquals(votacaoMocker.getVoto(), votacaoDTO.getVote());
    }
}
