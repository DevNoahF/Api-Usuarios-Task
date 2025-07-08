package java10x.devnoah.apicadastro.Usuario;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota!";
    }

    //Add
    @PostMapping("/criar")
    public String criarUsuario(){
        return "Usuário criado com sucesso!";
    }

    //Delete
    @DeleteMapping("/deletar/id")
    public String deletarUsuario(){
        return "Usuario deletado";
    }

    //read-return
    @GetMapping("/listar")
    public List<UsuarioModel> listar(){
        return usuarioService.listar();
    }

    //read id - return id
    @GetMapping("/listar/id")
    public String listarporid(){
        return "Lista de usuário por id";
    }

    //edit - update
    @PutMapping("/editar/id")
    public String editarUsuario() {
        return "Usuário editado com sucesso!";
    }


}

