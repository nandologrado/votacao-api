package br.com.votacao.api.exception;

public class VotacaoNotFoundException  extends ResourceNotFoundException {

    private static final long serialVersionUID = -1214125915328056099L;

    public VotacaoNotFoundException(Long id) {
        super(String.format("Votação #%d não encontrada", id));
    }
}
