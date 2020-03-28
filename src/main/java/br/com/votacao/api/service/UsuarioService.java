package br.com.votacao.api.service;

import br.com.votacao.api.dto.UsuarioDTO;
import br.com.votacao.api.entity.Usuario;
import br.com.votacao.api.exception.UsuarioExistsException;
import br.com.votacao.api.exception.UsuarioNotFoundException;
import br.com.votacao.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    @Transactional(readOnly = false)
    public Usuario save(UsuarioDTO usuarioDTO) {
        if (Optional.ofNullable(repository.findByCpf(usuarioDTO.getCpf())).isPresent()) {
            throw new UsuarioExistsException(usuarioDTO.getCpf());
        }
        return repository.save(usuarioDTO.toEntity());
    }
}
