package java10x.devnoah.apicadastro.Usuario;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //Add
    @Operation(summary = "Criar um novo usuário", description = "Cria um novo usuário com os dados fornecidos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @PostMapping("/criar")
    public ResponseEntity<String> criarUser(@RequestBody UsuarioDTO usuario) {
        UsuarioDTO novoUser = usuarioService.criarUser(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario : " + novoUser.getNome().toUpperCase() + " com ID : " + novoUser.getId() + " foi criado!");
    }

    //Delete
    @Operation(summary = "Deletar usuário por ID", description = "Remove um usuário existente pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        if (usuarioService.listarPorId(id) != null) {
            usuarioService.deletarUserId(id);
            return ResponseEntity.ok("Usuario de ID : " + id + " foi deletado!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O usuario de ID : " + id + " não foi encontrado.");
        }
    }

    //read-return
    @Operation(summary = "Listar todos os usuários", description = "Retorna uma lista com todos os usuários cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuários listados com sucesso")
    })
    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTO>> listar() {
        List<UsuarioDTO> usuario = usuarioService.listar();
        return ResponseEntity.ok(usuario);
    }

    //read id - return id
    @Operation(summary = "Buscar usuário por ID", description = "Retorna os dados de um usuário específico pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarId(@PathVariable Long id) {
        UsuarioDTO usuario = usuarioService.listarPorId(id);
        if (usuario != null){
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O usuario com ID: " + id + " não foi encontrado!");
        }
    }

    //edit - update
    @Operation(summary = "Atualizar usuário por ID", description = "Atualiza os dados de um usuário existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuario = usuarioService.atualizarPorId(id,usuarioDTO);
        if (usuario != null){
            return ResponseEntity.ok(usuario);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario com id: " + id + " não encontrado");
        }
    }

}
