package br.com.votacao.api.votacao.repository;

import br.com.votacao.api.votacao.entity.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long>{
}
