package com.loginComJwt.loginJWT.controller.user;

import com.loginComJwt.loginJWT.dto.userDto.*;
import com.loginComJwt.loginJWT.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){this.userService = userService;}

    @Operation(
            summary = "Trás todos os usuários registrados na plataforma."
    )
    @PreAuthorize("hasRole('USER', 'ADMIN')")
    @GetMapping
    public ResponseEntity<List<UserResponseGetDTO>> verUsuarios(){
        return ResponseEntity.ok(userService.exibirUsuarios());
    }

    @Operation(
            summary = "Trás apenas um usuário pelo email cadastrado.",
            description = "Busca o usuário pelo email fornecido na URL."
    )
    @PreAuthorize("hasRole('USER', 'ADMIN')")
    @GetMapping("email/{email}")
    public ResponseEntity<UserResponseGetDTO> buscarUsuarioEmail(
            @Parameter(description = "O email que será passado na url")
            @PathVariable String email){
        return ResponseEntity.ok(userService.encontrarUsuarioEmail(email));
    }

    @Operation(
            summary = "Busca um usuário por pelo ID que foi gerado pelo DB."
    )
    @PreAuthorize("hasRole('USER', 'ADMIN')")
    @GetMapping("id/{id}")
    public ResponseEntity<UserResponseGetDTO> buscarUsuarioById(
            @Parameter(description = "ID passado na url será armazenado na variavel ID")
            @PathVariable Long id){
        return ResponseEntity.ok(userService.encontrarUsuarioById(id));
    }

    @Operation(
            summary = "Atualiza o campo nome do usuário",
            description = "Atualzia o campo nome pegando o ID do usuário. " +
                    "Depois de encontrar no banco passamos o novo valor, atualização só é possivel se o usuário for o dono da conta"
    )
    @PreAuthorize("hasRole('USER', 'ADMIN')")
    @PatchMapping("update/name/{id}")
    public ResponseEntity<UserResponseGetNamePatchDTO> atualizarNome(
            @Parameter(description = "O identificador do usuário que vai ser atualizado.")
            @PathVariable Long id,
            @RequestBody UserRequestSetNamePatchDTO name){
        return ResponseEntity.ok(userService.atualizarNome(id,name));
    }

    @Operation(
            summary = "Atualiza o email do usuário.",
            description = "Atualiza o email do usuário, procuramos ele no banco pelo identificador ID " +
                    "que foi fornecido dessa forma atualizamos as informções. Só o dono da conta pode fazer a atualização."
    )
    @PreAuthorize("hasRole('USER', 'ADMIN')")
    @PatchMapping("update/email/{id}")
    public ResponseEntity<UserResponseGetEmailPatchDTO> atualizarEmail(
            @Parameter(description = "O identificador do usuário que vai ser atualizado.")
            @PathVariable Long id,
            @RequestBody UserRequestSetEmailPatchDTO email){
        return ResponseEntity.ok(userService.atualizarEmail(id, email));
    }

    @Operation(
            summary = "Atualiza a senha do usuário",
            description = "Senha será atualizada, para encontrar o usuário é necessário informar o ID." +
                    "apenas o dono da conta pode atualizar a propria senha."
    )
    @PreAuthorize("hasRole('USER', 'ADMIN')")
    @PatchMapping("update/password/{id}")
    public ResponseEntity<String> atualizarSenha(
            @Parameter(description = "O identificador do usuário que vai ser atualizado.")
            @PathVariable Long id,
            @RequestBody UserRequestSetSenhaPatchDTO senha){
        userService.atualizarSenha(id, senha);
        return ResponseEntity.ok("Senha atualizada com sucesso");
    }

    @Operation(
            summary = "Desativa a conta do usuário",
            description = "É realizado um soft delete, a conta continua no db porém não vai ser exibida" +
                    "nas querys, pois mudamos o valor de ativa para zero"
    )
    @PreAuthorize("hasRole('USER', 'ADMIN')")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> desativarUsuario(
            @PathVariable Long id
    ){
        userService.desativarUsuario(id);
        return ResponseEntity.ok("Usuário desativado com sucesso");
    }

    @Operation(
            summary = "Reativa a conta do usuário",
            description = "Essa rota não tem proteção de JWT está livre, para que dessa forma um usuário que tenha desativado" +
                    "a conta consiga reativar a mesma."
    )
    @PatchMapping("reactivate")
    public ResponseEntity<String> reactivarConta(
            @RequestBody UserRequestSetEmailPatchDTO email){
        userService.reativarUsuario(email);
        return ResponseEntity.ok("Usuário reactivado com sucesso");
    }

}
