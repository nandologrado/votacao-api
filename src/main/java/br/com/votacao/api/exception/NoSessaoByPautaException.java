package br.com.votacao.api.exception;

public class NoSessaoByPautaException extends ResourceNotFoundException {

    private static final long serialVersionUID = 2424512752222016942L;

    public NoSessaoByPautaException(Long pautaId) {
        super(String.format("Não existe nenhuma sessão para a pauta #%d", pautaId));
    }
}
