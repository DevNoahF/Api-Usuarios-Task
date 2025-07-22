package java10x.devnoah.apicadastro.Task;


import java10x.devnoah.apicadastro.Usuario.UsuarioMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<TaskDTO> listar() {
        List<TaskModel> task = taskRepository.findAll();
        return task.stream()
                .map(taskMapper::map)
                .collect(Collectors.toList());
    }

    // listar por id
    public TaskDTO listarPorId(Long id) {
        Optional<TaskModel> taskModel = taskRepository.findById(id);
        return taskModel.map(taskMapper::map).orElse(null);
    }

    //deletar
    public void deletarTaskId(Long id) {
        taskRepository.deleteById(id);
    }


    //editar
    public TaskDTO atualizarPorId(Long id, TaskDTO task) {
        Optional<TaskModel> taskModel = taskRepository.findById(id);
        if (taskModel.isPresent()) {
            TaskModel taskUpdated = taskMapper.map(new TaskDTO());
            taskUpdated.setId(id);
            TaskModel taskSaved = taskRepository.save(taskUpdated);
            return taskMapper.map(taskSaved);
        }
        return null;
    }
}
