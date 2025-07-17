package java10x.devnoah.apicadastro.Usuario;

import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public UsuarioModel map(UsuarioDTO usuario){
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setId(usuario.getId());
        usuarioModel.setNome(usuario.getNome());
        usuarioModel.setEmail(usuario.getEmail());
        usuarioModel.setIdade(usuario.getIdade());
        usuarioModel.setSexo(usuario.getSexo());
        usuarioModel.setTask(usuario.getTask());
        return usuarioModel;
    }

    public UsuarioDTO map(UsuarioModel usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setIdade(usuario.getIdade());
        usuarioDTO.setSexo(usuario.getSexo());
        usuarioDTO.setTask(usuario.getTask());
        return usuarioDTO;
    }
}
