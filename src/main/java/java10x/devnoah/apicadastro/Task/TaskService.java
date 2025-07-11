package java10x.devnoah.apicadastro.Task;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Método para criar uma nova tarefa
    public TaskModel criarTask(TaskModel taskModel) {
        return taskRepository.save(taskModel);
    }

    // listar
    public List<TaskModel> listar(){
        return taskRepository.findAll();
    }

    // listar por id
    public TaskModel listarPorId(Long id) {
        Optional<TaskModel> taskModel = taskRepository.findById(id);
        return taskRepository.findById(id).orElse(null);
    }

    //deletar
    public void deletarTaskId(Long id){
        taskRepository.deleteById(id);
    }


}
