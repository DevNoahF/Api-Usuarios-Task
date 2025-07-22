package java10x.devnoah.apicadastro.Usuario;
import java10x.devnoah.apicadastro.Task.TaskDTO;
import java10x.devnoah.apicadastro.Task.TaskModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    // Método para listar todos os usuários
    public List<UsuarioDTO> listar() {
        List<UsuarioModel> usuario = usuarioRepository.findAll(); // Busca todos os usuários do repositório
        return usuario.stream() // Converte a lista de UsuarioModel para uma lista de UsuarioDTO
                .map(usuarioMapper::map) // Mapeia cada UsuarioModel para UsuarioDTO
                .collect(Collectors.toList()); // Coleta os resultados em uma lista
    }

    // Método para criar um novo usuário
    public UsuarioDTO criarUser(UsuarioDTO usuarioDTO) {
        UsuarioModel usuarioModel = usuarioMapper.map(usuarioDTO);
        UsuarioModel usuario = usuarioRepository.save(usuarioModel);
        return usuarioMapper.map(usuario);
    }

    // Método para listar um usuário por ID
    public UsuarioDTO listarPorId(Long id) {
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);
        return usuario.map(usuarioMapper::map).orElse(null);
    }

    // Método para deletar um usuário por ID
    public void deletarUserId(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Método para editar um usuário
    public UsuarioDTO atualizarPorId(Long id, UsuarioDTO usuarioDTO) {
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){ // Verifica se o usuário existe
            UsuarioModel usuarioUpdated = usuarioMapper.map(usuarioDTO); // Mapeia o DTO para o modelo
            usuarioUpdated.setId(id); // Define o ID do usuário atualizado
            UsuarioModel usuarioSaved = usuarioRepository.save(usuarioUpdated); // Salva o usuário atualizado no repositório
            return usuarioMapper.map(usuarioSaved);
        }
        return null;
    }
}


