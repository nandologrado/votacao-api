package br.com.votacao.api.repository;

import br.com.votacao.api.entity.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long>{
    List<Sessao> findByPautaId(Long id);
}