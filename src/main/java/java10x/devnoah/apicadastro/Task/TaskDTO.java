package java10x.devnoah.apicadastro.Task;

import java10x.devnoah.apicadastro.Usuario.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    private Long id;
    private String nome;
    private String descricao;
    private List<UsuarioModel> usuarios;
}
