package java10x.devnoah.apicadastro.Task;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java10x.devnoah.apicadastro.Usuario.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_tasks")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "task",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<UsuarioModel> usuarios;
}
