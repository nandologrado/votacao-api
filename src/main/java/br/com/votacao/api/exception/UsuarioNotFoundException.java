package br.com.votacao.api.exception;

public class UsuarioNotFoundException extends ResourceNotFoundException {

    private static final long serialVersionUID = 3132047168456557481L;

	public UsuarioNotFoundException(Long id) {
        super(String.format("Usuário #%d não encontrado", id));
    }
}
