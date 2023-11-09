package com.example.Heranca.controller;

import com.example.Heranca.model.entity.Consulta;
import com.example.Heranca.model.entity.Medico;
import com.example.Heranca.model.repository.ConsultaRepository;
import com.example.Heranca.model.repository.MedicoRepository;
import com.example.Heranca.model.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Transactional
@Controller
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    ConsultaRepository repository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    MedicoRepository medicoRepository;

    @GetMapping("/form")
    public String form(Consulta consulta, ModelMap model){
        model.addAttribute("consulta", consulta);
        model.addAttribute("pacientes",pacienteRepository.pacientes());
        model.addAttribute("medicos",medicoRepository.medicos());
        return "/consultas/form";
    }

    @PostMapping("/save")
    public ModelAndView save(Consulta consulta){
        System.out.println(consulta.toString());
        repository.salvar(consulta);
        return new ModelAndView("redirect:/consultas/list");
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model){
        List<Consulta> consultas = repository.consultas();
        model.addAttribute("consultas", consultas);
        return new ModelAndView("/consultas/list", model);
    }

    @GetMapping("/listDetalhada/{id}")
    public ModelAndView detalhes(@PathVariable("id") Long id,ModelMap model){
        model.addAttribute("consulta", repository.getConsulta(id));
        return new ModelAndView("/consultas/detalhes", model);
    }
}
