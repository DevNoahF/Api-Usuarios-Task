package java10x.devnoah.apicadastro.Task;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Criar nova task", description = "Cria uma nova task com os dados fornecidos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Task criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @PostMapping("/criar")
    public ResponseEntity<String> criarTask(@RequestBody TaskDTO taskDTO) {
        TaskDTO usuario = taskService.criarTask(taskDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario criado!");
    }

    @Operation(summary = "Deletar task por ID", description = "Remove uma task existente pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Task não encontrada")
    })
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        if (taskService.listarPorId(id) != null){
            taskService.deletarTaskId(id);
            return ResponseEntity.ok("usuario deletado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario de ID: " + id + " nao encontrado!");
        }
    }

    @Operation(summary = "Listar todas as tasks", description = "Retorna uma lista com todas as tasks cadastradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tasks listadas com sucesso")
    })
    @GetMapping("/listar")
    public ResponseEntity<List<TaskDTO>> listar(){
        List<TaskDTO> task = taskService.listar();
        return ResponseEntity.ok(task);
    }

    @Operation(summary = "Buscar task por ID", description = "Retorna os dados de uma task específica pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task encontrada"),
            @ApiResponse(responseCode = "404", description = "Task não encontrada")
    })
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        TaskDTO task = taskService.listarPorId(id);
        if (task != null){
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Task de ID: " + id + " nao encontrada!");
        }
    }

    @Operation(summary = "Atualizar task por ID", description = "Atualiza os dados de uma task existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Task não encontrada")
    })
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody TaskDTO taskDTO){
        TaskDTO task = taskService.atualizarPorId(id, taskDTO);
        if (task != null){
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Task com ID: " + id + " nao foi encontrado");
        }
    }

}
