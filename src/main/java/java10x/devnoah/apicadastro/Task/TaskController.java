package java10x.devnoah.apicadastro.Task;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
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
    public ResponseEntity<String> criarTask(@RequestBody TaskDTO taskDTO) {
        TaskDTO usuario = taskService.criarTask(taskDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario criado!");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){

        if (taskService.listarPorId(id) != null){
            taskService.deletarTaskId(id);
            return ResponseEntity.ok("usuario deletado");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario de ID: " + id + " nao encontrado!");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TaskDTO>> listar(){
        List<TaskDTO> task =  taskService.listar();
        return ResponseEntity.ok(task);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        TaskDTO task = taskService.listarPorId(id);
        if (task != null){
            return ResponseEntity.ok(task);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Task de ID: " + id + " nao encontrada!");
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody TaskDTO taskDTO){
        TaskDTO task = taskService.atualizarPorId(id,taskDTO);
        if (task != null){
            return ResponseEntity.ok(task);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Task com ID: " + id + " nao foi encontrado");
        }
    }



}
