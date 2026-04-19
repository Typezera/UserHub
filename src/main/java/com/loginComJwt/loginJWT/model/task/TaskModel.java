package com.loginComJwt.loginJWT.model.task;

import com.loginComJwt.loginJWT.model.user.UserModel;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name="task")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private TarefaStatus status;

    @UpdateTimestamp
    private LocalDateTime data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UserModel usuario;



    public LocalDateTime getData() {
        return data;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public TarefaStatus getStatus() {
        return status;
    }

    public UserModel getUsuario() {
        return usuario;
    }

    public UserModel setUsuario(UserModel usuario){
        return this.usuario = usuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(TarefaStatus status) {
        this.status = status;
    }

}
