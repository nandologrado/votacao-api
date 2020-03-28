package br.com.votacao.api.repository;

import br.com.votacao.api.entity.Votacao;
import br.com.votacao.api.entity.VotacaoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, VotacaoPK> {

    List<Votacao> findBySessaoId(Long sessaoId);

    Votacao findBySessaoIdAndUsuarioId(Long sessaoId, Long usuarioId);

}