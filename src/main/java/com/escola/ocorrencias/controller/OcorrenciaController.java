
package com.escola.ocorrencias.controller;

import com.escola.ocorrencias.model.Ocorrencia;
import com.escola.ocorrencias.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ocorrencias")
public class OcorrenciaController {

    private final OcorrenciaRepository repo;
    private final ProfessorRepository professores;
    private final EstudanteRepository estudantes;

    public OcorrenciaController(OcorrenciaRepository repo, ProfessorRepository p, EstudanteRepository e){
        this.repo=repo;
        this.professores=p;
        this.estudantes=e;
    }

    @GetMapping("/nova")
    public String form(Model model){
        model.addAttribute("professores", professores.findAll());
        model.addAttribute("estudantes", estudantes.findAll());
        return "ocorrencia-form";
    }

    @PostMapping
    public String salvar(Ocorrencia o){
        repo.save(o);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
public String editar(@PathVariable Long id, Model model){

    Ocorrencia ocorrencia = repo.findById(id).orElse(null);

    model.addAttribute("ocorrencia", ocorrencia);
    model.addAttribute("professores", professores.findAll());
    model.addAttribute("estudantes", estudantes.findAll());

    return "ocorrencia-editar";
}

@PostMapping("/update")
public String update(Ocorrencia o){

    repo.save(o);

    return "redirect:/";
}

@GetMapping("/delete/{id}")
public String delete(@PathVariable Long id){

    repo.deleteById(id);

    return "redirect:/";
}
}
