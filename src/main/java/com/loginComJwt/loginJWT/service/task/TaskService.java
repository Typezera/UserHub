package com.loginComJwt.loginJWT.service.task;

import com.loginComJwt.loginJWT.dto.taskDto.TaskRequestDTO;
import com.loginComJwt.loginJWT.dto.taskDto.TaskResponseDTO;
import com.loginComJwt.loginJWT.dto.userDto.UserResponseGetDTO;
import com.loginComJwt.loginJWT.model.task.TaskModel;
import com.loginComJwt.loginJWT.model.user.UserModel;
import com.loginComJwt.loginJWT.repository.task.TaskRepository;
import com.loginComJwt.loginJWT.service.security.SecurityService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class TaskService {
   // private static final Logger logger = LoggerFactory.getLogger(TaskService.class);
    private final TaskRepository taskRepository;
    private final SecurityService securityService;
    public TaskService (TaskRepository taskRepository, SecurityService securityService){
        this.taskRepository = taskRepository;
        this.securityService = securityService;
    }

    public TaskResponseDTO criarTarefa(TaskRequestDTO taskRequest){
        UserModel usuarioLogado = securityService.getUsuarioLogado();

        TaskModel task = new TaskModel();
        task.setNome(taskRequest.nome());
        task.setDescricao(taskRequest.descricao());
        task.setStatus(taskRequest.status());
        task.setUsuario(usuarioLogado);
        UserModel u = usuarioLogado;

        UserResponseGetDTO userDTO = new UserResponseGetDTO(
          u.getId(),
          u.getNome(),
          u.getEmail()
        );


        TaskModel savedTask = taskRepository.save(task);

        return new TaskResponseDTO(
                savedTask.getId(),
                savedTask.getNome(),
                savedTask.getDescricao(),
                savedTask.getStatus(),
                savedTask.getData(),
                userDTO
        );
    }

}
