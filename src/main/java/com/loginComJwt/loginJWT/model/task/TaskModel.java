package com.loginComJwt.loginJWT.model.task;

import com.loginComJwt.loginJWT.model.user.UserModel;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="task")
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private TarefaStatus status;

    private LocalDateTime data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UserModel usuario;

}
