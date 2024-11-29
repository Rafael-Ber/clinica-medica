package br.edu.imepac.controllers;

import br.edu.imepac.models.Prontuario;
import br.edu.imepac.services.ProntuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/prontuarios")
public class ProntuarioController {

    @Autowired
    private ProntuarioService prontuarioService;

    @GetMapping
    public String listarProntuarios(Model model) {
        List<Prontuario> prontuarios = prontuarioService.findAll();
        model.addAttribute("prontuarios", prontuarios);
        return "prontuarios/listar";
    }

    @GetMapping("/novo")
    public String novoProntuarioForm(Model model) {
        model.addAttribute("prontuario", new Prontuario());
        return "prontuarios/novo";
    }

    @PostMapping
    public String salvarProntuario(@ModelAttribute Prontuario prontuario) {
        prontuarioService.save(prontuario);
        return "redirect:/prontuarios";
    }

    @GetMapping("/editar/{id}")
    public String editarProntuarioForm(@PathVariable Long id, Model model) {
        Prontuario prontuario = prontuarioService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("prontuario", prontuario);
        return "prontuarios/editar";
    }

    @PostMapping("/editar/{id}")
    public String atualizarProntuario(@PathVariable Long id, @ModelAttribute Prontuario prontuario) {
        prontuario.setId(id);
        prontuarioService.save(prontuario);
        return "redirect:/prontuarios";
    }

    @GetMapping("/deletar/{id}")
    public String deletarProntuario(@PathVariable Long id) {
        prontuarioService.deleteById(id);
        return "redirect:/prontuarios";
    }
}