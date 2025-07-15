package java10x.devnoah.apicadastro.Usuario;

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
    public UsuarioDTO criarUser(@RequestBody UsuarioDTO usuario){
        return usuarioService.criarUser(usuario);
    }

    //Delete
    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id){
        usuarioService.deletarUserId(id);
    }

    //read-return
    @GetMapping("/listar")
    public List<UsuarioModel> listar(){
        return usuarioService.listar();
    }

    //read id - return id
    @GetMapping("/listar/{id}")
    public UsuarioModel listarId(@PathVariable Long id){
        return usuarioService.listarPorId(id);
    }

    //edit - update
    @PutMapping("/atualizar/{id}")
    public UsuarioModel atualizar(@PathVariable Long id, @RequestBody UsuarioModel usuario) {
        return usuarioService.atualizarPorId(id,usuario);
    }


}

