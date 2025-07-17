package java10x.devnoah.apicadastro.Task;
import org.springframework.stereotype.Component;

@Component // Use @Component to allow Spring to manage this class as a bean
public class TaskMapper {
    public TaskModel map(TaskDTO task) {
        TaskModel taskModel = new TaskModel();
        taskModel.setId(task.getId());
        taskModel.setNome(task.getNome());
        taskModel.setDescricao(task.getDescricao());
        taskModel.setUsuarios(task.getUsuarios());
        return taskModel;
    }
    public TaskDTO map(TaskModel task){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setNome(task.getNome());
        taskDTO.setDescricao(task.getDescricao());
        taskDTO.setUsuarios(task.getUsuarios());
        return taskDTO;
    }




}
