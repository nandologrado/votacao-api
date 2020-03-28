package br.com.votacao.api.service;

import br.com.votacao.api.dto.VotacaoDTO;
import br.com.votacao.api.dto.VotoRequestDTO;
import br.com.votacao.api.entity.Sessao;
import br.com.votacao.api.entity.Usuario;
import br.com.votacao.api.entity.Votacao;
import br.com.votacao.api.entity.VotacaoPK;
import br.com.votacao.api.exception.SessaoExpiredException;
import br.com.votacao.api.exception.VotoExistsException;
import br.com.votacao.api.model.VotoEnum;
import br.com.votacao.api.repository.VotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class VotacaoService {

    private final VotacaoRepository repository;
    private final SessaoService sessaoService;
    private final UsuarioService usuarioService;

    @Autowired
    public VotacaoService(VotacaoRepository repository, SessaoService sessaoService, UsuarioService usuarioService) {
        this.repository = repository;
        this.sessaoService = sessaoService;
        this.usuarioService = usuarioService;
    }

    @Transactional(readOnly = false)
    public VotacaoDTO save(VotoRequestDTO votoRequestDTO) {
        Sessao sessao = sessaoService.findById(votoRequestDTO.getSessaoId());
        Usuario usuario = usuarioService.findById(votoRequestDTO.getUsuarioId());

        if (!sessao.getDataFim().isAfter(LocalDateTime.now())) {
            throw new SessaoExpiredException(sessao.getId());
        }

        if (Optional.ofNullable(repository.findBySessaoIdAndUsuarioId(sessao.getId(), usuario.getId())).isPresent()) {
            throw new VotoExistsException(usuario.getId(), sessao.getId());
        }

        return VotacaoDTO.valueOf(repository.save(createVotacao(sessao, usuario, votoRequestDTO.getVoto())));
    }

    private Votacao createVotacao(Sessao sessao, Usuario usuario, VotoEnum voto) {
        return Votacao.builder()
                .id(createVotacaoPK(sessao, usuario))
                .sessao(sessao)
                .usuario(usuario)
                .data(LocalDateTime.now())
                .voto(voto)
                .build();
    }

    private VotacaoPK createVotacaoPK(Sessao sessao, Usuario usuario) {
        return VotacaoPK.builder()
                .sessaoId(sessao.getId())
                .usuarioId(usuario.getId())
                .build();
    }
}
