package java10x.devnoah.apicadastro.Task;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository taskRepository;
    private TaskMapper taskMapper;
    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    // Método para criar uma nova tarefa
    public TaskDTO criarTask(TaskDTO taskDTO) {
        TaskModel task = taskMapper.map(taskDTO);
        TaskModel taskSave = taskRepository.save(task);
        return taskMapper.map(taskSave);
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

    //editar
    public TaskModel atualizarPorId(Long id, TaskModel task) {
        if(taskRepository.existsById(id)){
            taskRepository.save(task);
        }
        return taskRepository.save(task);
    }

}
