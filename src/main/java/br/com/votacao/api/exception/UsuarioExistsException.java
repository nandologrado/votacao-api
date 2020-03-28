package br.com.votacao.api.exception;

public class UsuarioExistsException extends BusinessException {

    private static final long serialVersionUID = -6333294537490660726L;

    public UsuarioExistsException(String cpf) {
        super(String.format("Usuário '%s' já registrado", cpf));
    }
}
