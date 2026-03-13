
package com.escola.ocorrencias.controller;
import com.escola.ocorrencias.model.Estudante;
import com.escola.ocorrencias.repository.EstudanteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/estudantes")
public class EstudanteController {

    private final EstudanteRepository repo;

    public EstudanteController(EstudanteRepository repo){this.repo=repo;}

    @GetMapping
    public String listar(Model model){
        model.addAttribute("lista", repo.findAll());
        return "estudantes";
    }

    @PostMapping
    public String salvar(Estudante e){
        repo.save(e);
        return "redirect:/estudantes";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        repo.deleteById(id);
        return "redirect:/estudantes";
    }

    @GetMapping("/editar/{matricula}")
public String editar(@PathVariable String matricula, Model model){

    Estudante estudante = repo.findById(matricula).orElse(null);

    model.addAttribute("estudante", estudante);

    return "estudante-editar";
}

@PostMapping("/update")
public String update(Estudante e){

    repo.save(e);

    return "redirect:/estudantes";
}
}
