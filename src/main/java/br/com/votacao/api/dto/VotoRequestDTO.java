package br.com.votacao.api.dto;

import br.com.votacao.api.model.VotoEnum;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
public class VotoRequestDTO  implements Serializable {

    private static final long serialVersionUID = 7156264219619737592L;

    @NotNull(message = "{votacao.sessao.notempty}")
    private Long sessaoId;

    @NotNull(message = "{votacao.usuario.notempty}")
    private Long usuarioId;

    @NotNull(message = "{votacao.voto.notempty}")
    private VotoEnum voto;

}
