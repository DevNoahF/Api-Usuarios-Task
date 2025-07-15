package java10x.devnoah.apicadastro.Task;

import java10x.devnoah.apicadastro.Usuario.UsuarioModel;
import java10x.devnoah.apicadastro.Usuario.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping("/criar")
    public TaskDTO criarTask(@RequestBody TaskDTO taskDTO) {
        return taskService.criarTask(taskDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id){
        taskService.deletarTaskId(id);
    }

    @GetMapping("/listar")
    public List<TaskModel> listar(){
        return taskService.listar();
    }

    @GetMapping("/listar/{id}")
    public TaskModel listarPorId(@PathVariable Long id){
        return taskService.listarPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public TaskModel atualizar(@PathVariable Long id, @RequestBody TaskModel task){
        return taskService.atualizarPorId(id,task);
    }



}
