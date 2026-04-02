package com.loginComJwt.loginJWT.dto.auth;

public record UserResponseDTO(
        Long id,
        String nome,
        String email,
        String telefone
) {
}
