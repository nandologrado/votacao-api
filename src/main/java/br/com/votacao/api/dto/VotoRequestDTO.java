package br.com.votacao.api.dto;

import br.com.votacao.api.model.VotoEnum;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class VotoRequestDTO  implements Serializable {

    private static final long serialVersionUID = 7156264219619737592L;

    private Long sessaoId;
    private Long usuarioId;
    private VotoEnum voto;

}
