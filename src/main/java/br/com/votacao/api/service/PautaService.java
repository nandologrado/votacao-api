package br.com.votacao.api.service;

import br.com.votacao.api.dto.PautaDTO;
import br.com.votacao.api.entity.Pauta;
import br.com.votacao.api.entity.Sessao;
import br.com.votacao.api.exception.PautaNotFoundException;
import br.com.votacao.api.repository.PautaRepository;
import br.com.votacao.api.repository.SessaoRepository;
import br.com.votacao.api.exception.PautaDeleteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class PautaService {

    private final PautaRepository repository;
    private final SessaoRepository sessaoRepository;

    @Autowired
    public PautaService(PautaRepository pautaRepository, SessaoRepository sessaoRepository) {
        this.repository = pautaRepository;
        this.sessaoRepository = sessaoRepository;
    }

    @Transactional(readOnly = true)
    public List<Pauta> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Pauta findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new PautaNotFoundException(id));
    }

    @Transactional(readOnly = false)
    public Pauta save(PautaDTO pautaDTO) {
        return repository.save(pautaDTO.toEntity());
    }

    @Transactional(readOnly = false)
    public void deleteById(Long id) {
        Pauta pauta = findById(id);
        if (!CollectionUtils.isEmpty(sessaoRepository.findByPautaId(id))) {
            throw new PautaDeleteException(pauta.getId());
        }

        repository.delete(pauta);
    }
}
