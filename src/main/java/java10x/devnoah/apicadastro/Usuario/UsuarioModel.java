package java10x.devnoah.apicadastro.Usuario;

import jakarta.persistence.*;
import java10x.devnoah.apicadastro.Task.TaskModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    private int idade;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskModel task;



}
