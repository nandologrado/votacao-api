package br.com.votacao.api.controller;

import br.com.votacao.api.dto.VotacaoDTO;
import br.com.votacao.api.dto.VotoRequestDTO;
import br.com.votacao.api.exception.BusinessException;
import br.com.votacao.api.service.VotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/votacoes")
public class VotacaoController {

    private final VotacaoService service;

    @Autowired
    public VotacaoController(VotacaoService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<VotacaoDTO> save(@RequestBody @Valid VotoRequestDTO votoRequestDTO,  Errors errors) {
        if (errors.hasErrors()) {
            throw new BusinessException(errors.toString());
        }
        return new ResponseEntity<>(service.save(votoRequestDTO), HttpStatus.CREATED);
    }
}
