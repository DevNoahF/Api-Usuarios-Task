package java10x.devnoah.apicadastro.Usuario;
import java10x.devnoah.apicadastro.Task.TaskDTO;
import java10x.devnoah.apicadastro.Task.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
@RequestMapping("/ui")
public class UsuarioControllerUI {

    private final UsuarioService usuarioService;
    private final TaskService taskService;

    public UsuarioControllerUI(UsuarioService usuarioService, TaskService taskService) {
        this.usuarioService = usuarioService;
        this.taskService = taskService;
    }

    @GetMapping ("/listar")
    public String listar(Model model){
        List<UsuarioDTO> usuarios = usuarioService.listar();
        model.addAttribute("usuarios", usuarios);
        return "listarUsuarios";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        usuarioService.deletarUserId(id);
        return "redirect:/ui/listar";
    }

    @GetMapping ("/detalhes/{id}")
    public String detalhes(@PathVariable Long id, Model model) {
        UsuarioDTO usuario = usuarioService.listarPorId(id);
        if (usuario != null) {
            model.addAttribute("usuarios", usuario);
            return "detalhesUsuarios";
        } else {
            return "listarUsuarios";
        }
    }

    @GetMapping("/adicionar")
    public String adicionar(Model model) {
        model.addAttribute(new UsuarioDTO());
        return "adicionarUsuarios";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute UsuarioDTO usuario, RedirectAttributes redirectAttributes) {
        usuarioService.criarUser(usuario);
        redirectAttributes.addFlashAttribute("mensagem", "Usuario cadastrado com sucesso!");
        return "redirect:/ui/listar";
    }



    // <-------   TASKS --------->

    @GetMapping("/addTasks")
    public String addTask(Model model){
        model.addAttribute(new TaskDTO());
        return "adicionarTasks";
    }

    @PostMapping ("/salvarTask")
    public String salvarTask(@ModelAttribute TaskDTO task, RedirectAttributes redirectAttributes){
        taskService.criarTask(task);
        redirectAttributes.addFlashAttribute("mensagem", "Task cadastrada com sucesso");
        return "redirect:/ui/listarTasks";
    }

    @GetMapping ("/listarTasks")
    public String listarTask(Model model){
        List<TaskDTO> task = taskService.listar();
        model.addAttribute("tasks", task);
        return "listarTasks";
    }

    @GetMapping("/deletarTask/{id}")
    public String deletarTask(@PathVariable Long id) {
        taskService.deletarTaskId(id);
        return "redirect:/ui/listarTasks";
    }








}
