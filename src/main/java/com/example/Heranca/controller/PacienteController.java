package com.example.Heranca.controller;

import com.example.Heranca.model.entity.Medico;
import com.example.Heranca.model.entity.Paciente;
import com.example.Heranca.model.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("pessoa/paciente")
public class PacienteController {

    @Autowired
    PacienteRepository repository;

    @GetMapping("/form")
    public String form( Paciente pessoa, ModelMap model){
        model.addAttribute("tipo","paciente");
        model.addAttribute("pessoa", pessoa);
        return "/pessoa/form";
    }

    @PostMapping("/save")
    public ModelAndView save(Paciente pessoa){
        repository.salvar(pessoa);
        return new ModelAndView("redirect:/pessoa/paciente/list");
    }

    @GetMapping("/list")
    public ModelAndView listarPacientes(ModelMap model){
        model.addAttribute("pacientes", repository.pacientes());
        return new ModelAndView("/pacientes/list", model);
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remover(id);
        return new ModelAndView("redirect:/pessoa/paciente/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("tipo","paciente");
        model.addAttribute("pessoa", repository.buscar(id));
        return new ModelAndView("/pessoa/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Paciente paciente) {
        repository.update(paciente);
        return new ModelAndView("redirect:/pessoa/paciente/list");
    }

}
