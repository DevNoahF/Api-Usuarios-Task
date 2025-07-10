package java10x.devnoah.apicadastro.Task;

import java10x.devnoah.apicadastro.Usuario.UsuarioModel;
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
    public TaskModel criarTask(@RequestBody TaskModel taskModel){
        return taskService.criarTask(taskModel);
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar(){
        return "tarefa deletada";
    }

    @GetMapping("/listar")
    public List<TaskModel> listar(){
        return taskService.listar();
    }

    @GetMapping("/listar/{id}")
    public TaskModel listarPorId(@PathVariable Long id){
        return taskService.listarPorId(id);
    }



}
