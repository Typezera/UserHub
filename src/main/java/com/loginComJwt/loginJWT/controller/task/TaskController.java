package com.loginComJwt.loginJWT.controller.task;

import com.loginComJwt.loginJWT.dto.taskDto.TaskRequestDTO;
import com.loginComJwt.loginJWT.dto.taskDto.TaskResponseDTO;
import com.loginComJwt.loginJWT.service.task.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){this.taskService = taskService;}

    @PostMapping("/create")
    public ResponseEntity<TaskResponseDTO> criarTarefas(
            @Valid @RequestBody TaskRequestDTO taskRequestDTO){
        return ResponseEntity.ok(taskService.criarTarefa(taskRequestDTO));
    };
}
