package br.com.votacao.api.mock;

import br.com.votacao.api.model.VotoEnum;

import java.util.Random;

import static br.com.votacao.api.dto.VotoRequestDTO.VotoRequestDTOBuilder;
import static br.com.votacao.api.dto.VotoRequestDTO.builder;

public class VotoResquestDTOMocker {

    private static VotoRequestDTOBuilder votoRequestDTOBuilder = builder();


    public VotoResquestDTOMocker() {
    }

    public static VotoRequestDTOBuilder random(){
        return votoRequestDTOBuilder
                .sessaoId(SessaoMocker.random().build().getId())
                .usuarioId(UsuarioMocker.random().build().getId())
                .voto(VotoEnum.values()[new Random().nextInt(VotoEnum.values().length-1)]);
    }
}
