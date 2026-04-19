package com.loginComJwt.loginJWT.repository.task;

import com.loginComJwt.loginJWT.model.task.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {
    List<TaskModel> findByUsuarioId(Long id);
}
