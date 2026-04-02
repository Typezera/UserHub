package com.loginComJwt.loginJWT.controller;

import com.loginComJwt.loginJWT.dto.UserRequestDTO;
import com.loginComJwt.loginJWT.dto.UserResponseDTO;
import com.loginComJwt.loginJWT.service.UserService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
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
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> cadastrarUsuario(@Valid @RequestBody UserRequestDTO userRequestDTO){
       var usuario = userService.criarUsuario(userRequestDTO);

       return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

}
