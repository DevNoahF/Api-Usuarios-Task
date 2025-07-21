package java10x.devnoah.apicadastro.Task;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
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
    public List<TaskDTO> listar(){
        return taskService.listar();
    }

    @GetMapping("/listar/{id}")
    public TaskDTO listarPorId(@PathVariable Long id){
        return taskService.listarPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public TaskDTO atualizar(@PathVariable Long id, @RequestBody TaskDTO task){
        return taskService.atualizarPorId(id,task);
    }



}
