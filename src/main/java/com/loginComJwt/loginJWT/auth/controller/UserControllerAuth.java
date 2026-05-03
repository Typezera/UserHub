package com.loginComJwt.loginJWT.auth.controller;

import com.loginComJwt.loginJWT.auth.dto.UserLoginRequestDTO;
import com.loginComJwt.loginJWT.auth.dto.UserLoginResponseDTO;
import com.loginComJwt.loginJWT.auth.dto.UserRequestDTO;
import com.loginComJwt.loginJWT.auth.dto.UserResponseDTO;
import com.loginComJwt.loginJWT.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/auth")
public class UserControllerAuth {
    private final UserService userService;
    public UserControllerAuth(UserService userService){
        this.userService = userService;
    }

    @Operation(
            summary = "Cria uma conta no sistema",
            description = "Apenas envia as credenciais necessárias."
    )
    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> cadastrarUsuario(@Valid @RequestBody UserRequestDTO userRequestDTO){
       var usuario = userService.criarUsuario(userRequestDTO);

       return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @Operation(
            summary = "Faz o login na conta criada.",
            description = "Fornece email e senha."
    )
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDTO> login (
            @RequestBody @Valid UserLoginRequestDTO requisicao
    ) {
        UserLoginResponseDTO response = userService.login(requisicao);
        return ResponseEntity.ok(response);
    }

}
