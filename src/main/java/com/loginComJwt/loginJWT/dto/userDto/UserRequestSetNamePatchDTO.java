package com.loginComJwt.loginJWT.dto.userDto;

import jakarta.validation.constraints.NotBlank;

public record UserRequestSetNamePatchDTO(
        @NotBlank(message = "Preencha o campo")
        String nome
) {
}
