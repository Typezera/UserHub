package com.loginComJwt.loginJWT.dto.taskDto;

import com.loginComJwt.loginJWT.model.task.TarefaStatus;
import com.loginComJwt.loginJWT.model.user.UserModel;

import java.time.LocalDateTime;

public record TaskResponseDTO(Long id, String nome, String descricao, TarefaStatus tarefaStatus, LocalDateTime data, Long usuarioId) {
}
