package br.com.votacao.api.exception;

public class PautaNotFoundException extends ResourceNotFoundException {

    private static final long serialVersionUID = -6222657121926683300L;

    public PautaNotFoundException(Long id) {
        super(String.format("Pauta #%d não encontrada", id));
    }
}
