package com.loginComJwt.loginJWT.controller.friendship;

import com.loginComJwt.loginJWT.dto.friendship.FriendshipResponseDTO;
import com.loginComJwt.loginJWT.service.friendship.FriendshipService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/pedido")
public class FriendshipController {
    private final FriendshipService friendshipService;
    public FriendshipController(FriendshipService friendshipService){
        this.friendshipService = friendshipService;
    }

    @Operation(
            summary = "Envia uma solicitação de amizade para um usuário.",
            description = "Apenas o usuário que recebeu a solicitação pode aceitar, " +
                    "O receiver não pode enviar uma outra solicitação para o sender," +
                    "dessa forma evitando duplicata de solicitações"
    )
    @PreAuthorize("hasRole('USER')")
    @PostMapping("{id}")
    public ResponseEntity<String> adicionarUsuario(
            @Parameter(description = "É necessário informar o ID do usuário que se deseja adicionar")
            @PathVariable Long id
    ){
        friendshipService.enviarSocilitacao(id);
        return ResponseEntity.ok("Solicitação enviada com sucesso.");
    }

    @Operation(
            summary = "Aceita a Solicitação",
            description = "O receiver pode aceitar a solicitação que foi enviada," +
                    "cada solicitação possui um ID, e ele aceita informando o ID da solicitação."
    )
    @PreAuthorize("hasRole('USER')")
    @PatchMapping("/{id}/aceitar")
    public ResponseEntity<String> aceitarSolicitacao(
            @Parameter(description = "ID da solicitação que deseja aceitar.")
            @PathVariable Long id
    ){
        friendshipService.aceitarSolicitacao(id);
        return ResponseEntity.ok("Solicitação aceita.");
    }

    @Operation(
            summary = "Recusa uma solicitação.",
            description = "O receiver pode recusar uma solicitação apenas pelo ID da solicitação."
    )
    @PreAuthorize("hasRole('USER')")
    @PatchMapping("/{id}/recusar")
    public ResponseEntity<String> recusarSolicitacao(
            @Parameter(description = "ID da solicitação que deseja recusar")
            @PathVariable Long id
    ){
        friendshipService.recusarSolicitacao(id);
        return ResponseEntity.ok("Solicitação recusada.");
    }

    @Operation(
            summary = "Mostra todos os pedidos que o dono da conta tem",
            description = "Exibe todas as solicitaçãoes que o dono da conta tem em pendente para aceitar/recusar"
    )
    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public ResponseEntity<List<FriendshipResponseDTO>> mostrarPedidos(){
        return ResponseEntity.ok(friendshipService.verSolicitacoes());
    }
}
