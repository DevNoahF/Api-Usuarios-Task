package java10x.devnoah.apicadastro.Usuario;

import java10x.devnoah.apicadastro.Task.TaskModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private int idade;
    private String sexo;
    private TaskModel task;
}
