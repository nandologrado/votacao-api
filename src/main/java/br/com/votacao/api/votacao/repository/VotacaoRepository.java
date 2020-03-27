package br.com.votacao.api.votacao.repository;

import br.com.votacao.api.votacao.entity.Votacao;
import br.com.votacao.api.votacao.entity.VotacaoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, VotacaoPK> {
}
