package com.loginComJwt.loginJWT.service.task;

import com.loginComJwt.loginJWT.repository.task.TaskRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class TaskService {
   // private static final Logger logger = LoggerFactory.getLogger(TaskService.class);
    private final TaskRepository taskRepository;
    public TaskService (TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }



}
