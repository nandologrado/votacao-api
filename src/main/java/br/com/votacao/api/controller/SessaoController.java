package br.com.votacao.api.controller;

import br.com.votacao.api.dto.SessaoDTO;
import br.com.votacao.api.dto.SessaoRequestDTO;
import br.com.votacao.api.dto.SessaoResultadoDTO;
import br.com.votacao.api.exception.BusinessException;
import br.com.votacao.api.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/v1/sessoes")
public class SessaoController {

    private final SessaoService service;

    @Autowired
    SessaoController(SessaoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    ResponseEntity<SessaoDTO> findById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(SessaoDTO.valueOf(service.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/pauta/{id}")
    ResponseEntity<List<SessaoDTO>> findByPauta(@PathVariable(value = "id") Long pautaId) {
        return new ResponseEntity<>(service.findByPauta(pautaId)
                .stream()
                .map(SessaoDTO::valueOf)
                .collect(toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}/details")
    ResponseEntity<SessaoResultadoDTO> findSessaoDetailsById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(service.findSessaoDetailsById(id), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<SessaoDTO> save(@RequestBody @Valid SessaoRequestDTO sessaoRequestDTO, Errors errors) {
        if (errors.hasErrors()) {
            throw new BusinessException(errors.toString());
        }
        return new ResponseEntity<>(SessaoDTO.valueOf(service.save(sessaoRequestDTO)), HttpStatus.CREATED);
    }

}
