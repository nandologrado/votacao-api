package br.com.votacao.api.controller;

import br.com.votacao.api.dto.UsuarioDTO;
import br.com.votacao.api.exception.BusinessException;
import br.com.votacao.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    @Autowired
    UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<UsuarioDTO>> findAll() {
        return new ResponseEntity<>(service.findAll()
                .stream()
                .map(UsuarioDTO::valueOf)
                .collect(toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<UsuarioDTO> findById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(UsuarioDTO.valueOf(service.findById(id)), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<UsuarioDTO> save(@RequestBody @Valid UsuarioDTO usuarioDTO, Errors errors) {
        if (errors.hasErrors()) {
            throw new BusinessException(errors.toString());
        }
        return new ResponseEntity<>(UsuarioDTO.valueOf(service.save(usuarioDTO)), HttpStatus.CREATED);
    }

}
