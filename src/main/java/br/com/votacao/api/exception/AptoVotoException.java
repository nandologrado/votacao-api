package br.com.votacao.api.exception;

public class AptoVotoException extends BusinessException {

    private static final long serialVersionUID = -443071071765793686L;

    public AptoVotoException(String cpf) {
        super(String.format("CPF '%s' não apto a voltação",cpf));
    }
}
