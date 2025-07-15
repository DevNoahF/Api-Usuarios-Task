package java10x.devnoah.apicadastro.Usuario;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private UsuarioMapper usuarioMapper;
    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    // Método para listar todos os usuários
    public List<UsuarioModel> listar() {
        return usuarioRepository.findAll();
    }

    // Método para criar um novo usuário
    public UsuarioDTO criarUser(UsuarioDTO usuarioDTO){
        UsuarioModel usuarioModel = usuarioMapper.map(usuarioDTO);
        UsuarioModel usuario = usuarioRepository.save(usuarioModel);
        return usuarioMapper.map(usuario);
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

    // Método para editar um usuário
    public UsuarioModel atualizarPorId(Long id, UsuarioModel usuario){
        if(usuarioRepository.existsById(id)){
            usuario.setId(id);}
        return usuarioRepository.save(usuario);
    }
}
