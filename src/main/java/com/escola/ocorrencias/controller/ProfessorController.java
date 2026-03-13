
package com.escola.ocorrencias.controller;
import com.escola.ocorrencias.model.Professor;
import com.escola.ocorrencias.repository.ProfessorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorRepository repo;

    public ProfessorController(ProfessorRepository repo){this.repo=repo;}

    @GetMapping
    public String listar(Model model){
        model.addAttribute("lista", repo.findAll());
        return "professores";
    }

    @PostMapping
    public String salvar(Professor p){
        repo.save(p);
        return "redirect:/professores";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        repo.deleteById(id);
        return "redirect:/professores";
    }

    @GetMapping("/editar/{id}")
public String editar(@PathVariable String id, Model model){
    model.addAttribute("professor", repo.findById(id).orElse(null));
    return "professor-editar";
}

@PostMapping("/update")
public String update(Professor p){
    repo.save(p);
    return "redirect:/professores";
}
}
