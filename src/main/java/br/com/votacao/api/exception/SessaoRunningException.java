package br.com.votacao.api.exception;

public class SessaoRunningException extends BusinessException {

    private static final long serialVersionUID = 2424512752222016942L;

    public SessaoRunningException(Long id) {
        super(String.format("A sessão #%d está aberta. O resultado não pode ser exibidos", id));
    }
}
