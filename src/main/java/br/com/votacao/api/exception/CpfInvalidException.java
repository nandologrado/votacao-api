package br.com.votacao.api.exception;

public class CpfInvalidException extends BusinessException {

    private static final long serialVersionUID = 1124832290144367633L;

    public CpfInvalidException(String cpf) {
        super(String.format("CPF '%s' inválido",cpf));
    }
}
