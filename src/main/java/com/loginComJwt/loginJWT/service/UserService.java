package com.loginComJwt.loginJWT.service;

import com.loginComJwt.loginJWT.dto.auth.UserLoginRequestDTO;
import com.loginComJwt.loginJWT.dto.auth.UserLoginResponseDTO;
import com.loginComJwt.loginJWT.dto.auth.UserRequestDTO;
import com.loginComJwt.loginJWT.dto.auth.UserResponseDTO;
import com.loginComJwt.loginJWT.model.UserModel;
import com.loginComJwt.loginJWT.repository.UserRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //{metodo de criação de usuário, vai ser chamado no controller: [POST]}
    public UserResponseDTO criarUsuario(UserRequestDTO userRequest){
        UserModel user = new UserModel();
        user.setNome(userRequest.nome());
        user.setEmail(userRequest.email());
        user.setSenha(userRequest.senha());
        user.setTelefone(userRequest.telefone());

        UserModel usuario = userRepository.save(user);

        return new UserResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone()
        );
    }
// em implementação
//    public UserLoginResponseDTO encontrarEmail(UserLoginRequestDTO user){
//        var usuario =  userRepository.findByEmail(user.email())
//                .orElseThrow(() -> new ResponseStatusException(
//                        HttpStatus.NOT_FOUND,
//                        "Usuário com o Email: " + user.email() + " não encontrado."
//                ));
//        return usuario
//    }

}
