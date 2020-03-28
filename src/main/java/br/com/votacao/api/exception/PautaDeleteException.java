package br.com.votacao.api.exception;

public class PautaDeleteException extends BusinessException {

    private static final long serialVersionUID = 1124832290144367633L;

    public PautaDeleteException(Long pautaId) {
        super(String.format("Não é possivel excluir a pauta #%d. Existe sessões associadas a mesma",pautaId));
    }

}
