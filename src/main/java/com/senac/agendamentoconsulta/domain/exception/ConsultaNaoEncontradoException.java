package com.senac.agendamentoconsulta.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ConsultaNaoEncontradoException extends EntidadeNaoEncontradaException {

    public ConsultaNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
    public ConsultaNaoEncontradoException(Long id){
        this(String.format("Não existe um cadastro de consulta com código %d", id));
    }
}
