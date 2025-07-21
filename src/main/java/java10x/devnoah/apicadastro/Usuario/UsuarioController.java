package java10x.devnoah.apicadastro.Usuario;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //Add
    @PostMapping("/criar")
    public ResponseEntity<String> criarUser(@RequestBody UsuarioDTO usuario) {
        UsuarioDTO novoUser = usuarioService.criarUser(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario : " + novoUser.getNome().toUpperCase() + " com ID : " + novoUser.getId() + " foi criado!");
    }

    //Delete
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
    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTO>> listar() {
        List<UsuarioDTO> usuario = usuarioService.listar();
        return ResponseEntity.ok(usuario);
    }

    //read id - return id
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

