package java10x.devnoah.apicadastro.Usuario;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    // Construtor para injeção de dependência do repositório
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Método para listar todos os usuários
    public List<UsuarioModel> listar() {
        return usuarioRepository.findAll();
    }

    // Método para criar um novo usuário
    public UsuarioModel criarUser(UsuarioModel usuarioModel){
        return usuarioRepository.save(usuarioModel);
    }

    // Método para listar um usuário por ID
    public UsuarioModel listarPorId(Long id){
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    // Método para deletar um usuário por ID
    public void deletarUserId(Long id){
        usuarioRepository.deleteById(id);
    }

}
