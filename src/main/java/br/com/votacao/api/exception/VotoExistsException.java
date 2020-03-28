package br.com.votacao.api.exception;

public class VotoExistsException  extends BusinessException {

    private static final long serialVersionUID = -5573752335086490681L;

    public VotoExistsException(Long usuarioId, Long sessaoId) {
        super(String.format("Usuário #%d já votou na sessão #%d", usuarioId,sessaoId));
    }
}
