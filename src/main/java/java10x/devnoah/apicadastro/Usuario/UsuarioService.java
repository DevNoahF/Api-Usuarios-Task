package java10x.devnoah.apicadastro.Usuario;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioModel> listar() {
        return usuarioRepository.findAll();
    }
}
