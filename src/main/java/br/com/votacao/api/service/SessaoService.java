package br.com.votacao.api.service;

import br.com.votacao.api.dto.PautaDTO;
import br.com.votacao.api.dto.SessaoRequestDTO;
import br.com.votacao.api.dto.SessaoResultadoDTO;
import br.com.votacao.api.dto.SessaoResultadoVotosDTO;
import br.com.votacao.api.entity.Pauta;
import br.com.votacao.api.entity.Sessao;
import br.com.votacao.api.entity.Votacao;
import br.com.votacao.api.exception.NoSessaoByPautaException;
import br.com.votacao.api.exception.SessaoNotFoundException;
import br.com.votacao.api.exception.SessaoRunningException;
import br.com.votacao.api.model.VotoEnum;
import br.com.votacao.api.repository.SessaoRepository;
import br.com.votacao.api.repository.VotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class SessaoService {

    private final SessaoRepository repository;
    private final PautaService pautaService;
    private final VotacaoRepository votacaoRepository;
    private static final int SESSAO_DURACAO_DEFAULT_SECONDS = 60;

    @Autowired
    public SessaoService(SessaoRepository repository, PautaService pautaService, VotacaoRepository votacaoRepository) {
        this.repository = repository;
        this.pautaService = pautaService;
        this.votacaoRepository = votacaoRepository;
    }

    @Transactional(readOnly = true)
    public Sessao findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new SessaoNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public List<Sessao> findByPauta(Long pautaId) {
        List<Sessao> sessaoList = repository.findByPautaId(pautaId);
        if (CollectionUtils.isEmpty(sessaoList)) {
            throw new NoSessaoByPautaException(pautaId);
        }

        return sessaoList;
    }

    @Transactional(readOnly = true)
    public SessaoResultadoDTO findSessaoDetailsById(Long id) {
        Sessao sessao = findById(id);
        LocalDateTime now = LocalDateTime.now();
        if (sessao.getDataFim().isAfter(now) && sessao.getDataInicio().isBefore(now)) {
            throw new SessaoRunningException(id);
        }

        return this.createSessaoResultado(sessao, votacaoRepository.findBySessaoId(id));
    }

    @Transactional(readOnly = false)
    public Sessao save(SessaoRequestDTO sessaoRequestDTO) {
        Pauta pauta = pautaService.findById(sessaoRequestDTO.getPautaId());
        return repository.save(createSessao(pauta, sessaoRequestDTO));
    }

    private SessaoResultadoDTO createSessaoResultado(Sessao sessao, List<Votacao> votacoes) {
        return SessaoResultadoDTO.builder()
                .pautaDTO(PautaDTO.valueOf(sessao.getPauta()))
                .durationMinutes(Duration.between(sessao.getDataInicio(), sessao.getDataFim()).toMinutes())
                .sessaoResultadoVotosDTO(createSessaoResultadoVotos(votacoes))
                .build();
    }

    private SessaoResultadoVotosDTO createSessaoResultadoVotos(List<Votacao> votacoes) {
        return SessaoResultadoVotosDTO.builder()
                .totalVotos(votacoes.size())
                .totalSimVotos(this.processVotos(VotoEnum.SIM, votacoes))
                .totalNaoVotos(this.processVotos(VotoEnum.NAO, votacoes))
                .build();
    }

    public static int processVotos(VotoEnum voto, List<Votacao> votacoes) {
        return votacoes.stream()
                .filter(votacao -> votacao.getVoto().equals(voto))
                .collect(toList()).size();
    }

    private Sessao createSessao(Pauta pauta, SessaoRequestDTO sessaoRequestDTO) {
        LocalDateTime now = LocalDateTime.now();

        return Sessao.builder()
                .pauta(pauta)
                .dataInicio(now)
                .dataFim(this.processDataFim(sessaoRequestDTO, now))
                .build();
    }

    private static LocalDateTime processDataFim(SessaoRequestDTO sessaoRequestDTO, LocalDateTime dataInicio) {
        return dataInicio.plusSeconds(Optional
                .ofNullable(sessaoRequestDTO.getDuracaoSessao())
                .orElse(SESSAO_DURACAO_DEFAULT_SECONDS));
    }

}
