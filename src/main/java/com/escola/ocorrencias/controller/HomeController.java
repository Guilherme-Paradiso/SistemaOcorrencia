
package com.escola.ocorrencias.controller;

import com.escola.ocorrencias.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private final OcorrenciaRepository ocorrencias;
    private final ProfessorRepository professores;
    private final EstudanteRepository estudantes;

    public HomeController(OcorrenciaRepository ocorrencias,
                          ProfessorRepository professores,
                          EstudanteRepository estudantes){
        this.ocorrencias = ocorrencias;
        this.professores = professores;
        this.estudantes = estudantes;
    }

    @GetMapping("/")
    public String home(Model model){

        model.addAttribute("lista", ocorrencias.findAll());
        model.addAttribute("professores", professores.findAll());
        model.addAttribute("estudantes", estudantes.findAll());

        return "index";
    }

@GetMapping("/filtro")
public String filtro(@RequestParam(required=false) String professor,
                     @RequestParam(required=false) String estudante,
                     Model model){

    if(professor != null && !professor.isEmpty()) {
        model.addAttribute("lista", ocorrencias.findByProfessorCodigo(professor));
        model.addAttribute("professorSelecionado", professor);
    }
    else if(estudante != null && !estudante.isEmpty()) {
        model.addAttribute("lista", ocorrencias.findByEstudanteMatricula(estudante));
        model.addAttribute("estudanteSelecionado", estudante);
    }
    else {
        model.addAttribute("lista", ocorrencias.findAll());
    }

    model.addAttribute("professores", professores.findAll());
    model.addAttribute("estudantes", estudantes.findAll());

    return "index";
}
}