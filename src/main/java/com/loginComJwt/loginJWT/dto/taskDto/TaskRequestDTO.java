package com.loginComJwt.loginJWT.dto.taskDto;

import com.loginComJwt.loginJWT.model.task.TarefaStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskRequestDTO (
        @NotBlank(message = "Insira um nome para a tarefa")
        String nome,
        @NotBlank(message = "Coloque uma descrição.")
        String descricao,
        @NotNull(message = "Status obrigatorio.")
        TarefaStatus status
){ }
