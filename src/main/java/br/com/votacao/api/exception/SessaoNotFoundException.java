package br.com.votacao.api.exception;

public class SessaoNotFoundException extends ResourceNotFoundException {

    private static final long serialVersionUID = 6630909434629295068L;

    public SessaoNotFoundException(Long id) {
        super(String.format("Sessão #%d não encontrada", id));
    }
}
