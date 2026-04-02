package com.loginComJwt.loginJWT.service;

import com.loginComJwt.loginJWT.dto.UserRequestDTO;
import com.loginComJwt.loginJWT.dto.UserResponseDTO;
import com.loginComJwt.loginJWT.model.UserModel;
import com.loginComJwt.loginJWT.repository.UserRepository;
import org.springframework.stereotype.Service;

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

}
