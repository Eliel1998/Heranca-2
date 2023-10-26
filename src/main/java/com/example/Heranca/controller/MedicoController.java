package com.example.Heranca.controller;

import com.example.Heranca.model.entity.Medico;
import com.example.Heranca.model.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("pessoa/medico")
public class MedicoController {

    @Autowired
    MedicoRepository repository;

    @GetMapping("/form")
    public String form(Medico pessoa, ModelMap model){
        model.addAttribute("tipo","medico");
        model.addAttribute("pessoa", pessoa);
        return "/pessoa/form";
    }

    @PostMapping("/save")
    public ModelAndView save(Medico pessoa){
        repository.salvar(pessoa);
        return new ModelAndView("redirect:/pessoa/medico/list");
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model){
        model.addAttribute("medicos", repository.buscarPorMedicos());
        return new ModelAndView("/medicos/list", model);
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remover(id);
        return new ModelAndView("redirect:/pessoa/medico/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("tipo","medico");
        model.addAttribute("pessoa", repository.buscar(id));
        return new ModelAndView("/pessoa/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Medico medico) {
        repository.atualizar(medico);
        return new ModelAndView("redirect:/pessoa/medico/list");
    }

}
