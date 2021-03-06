package br.com.votacao.api.controller;

import br.com.votacao.api.dto.PautaDTO;
import br.com.votacao.api.exception.BusinessException;
import br.com.votacao.api.service.PautaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/v1/pautas")
public class PautaController {

    private final PautaService service;

    @Autowired
    public PautaController(PautaService service) {
        this.service = service;
    }

    @ApiOperation(value = "Retorna todas a pautas cadastradas")
    @GetMapping
    ResponseEntity<List<PautaDTO>> findAll() {
        return new ResponseEntity<>(service.findAll()
                .stream()
                .map(PautaDTO::valueOf)
                .collect(toList()), HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna uma pauta pelo seu ID")
    @GetMapping("/{id}")
    ResponseEntity<PautaDTO> findById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(PautaDTO.valueOf(service.findById(id)), HttpStatus.OK);
    }

    @ApiOperation(value = "Salva uma Pauta")
    @PostMapping
    ResponseEntity<PautaDTO> save(@RequestBody @Valid PautaDTO pautaDTO, Errors errors) {
        if (errors.hasErrors()) {
            throw new BusinessException(errors.toString());
        }
        return new ResponseEntity<>(pautaDTO.valueOf(service.save(pautaDTO)), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Deletando uma pauta pelo ID")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
