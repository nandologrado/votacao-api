package br.com.votacao.api.exception;

public class SessaoExpiredException extends BusinessException {

    private static final long serialVersionUID = -732836370270275246L;

    public SessaoExpiredException(Long id) {
        super(String.format("Sessão #%d expirou", id));
    }
}
