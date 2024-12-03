package com.example.tpbase.controller;

import com.example.tpbase.Service.IComputerService;
import com.example.tpbase.model.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/computer")
public class ComputerController {
    @Autowired
    private IComputerService service;
    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }
    @GetMapping("/ajouter")
    public String showRegistration() {
        return "ajoutcomputerPage";
    }
    @PostMapping("/save")
    public String saveComputer(
            @ModelAttribute Computer computer, Model model
    ) {
        service.saveComputer(computer);
        Long id = (long) service.saveComputer(computer).getId();
        String message = "Record with id : '"+id+"' is saved successfully !";
        model.addAttribute("message", message);
        return "ajoutcomputerPage";
    }
    @GetMapping("/getAllComputers")
    public String getAllComputers(
            @RequestParam(value = "message", required = false)
            String message,
            Model model
    ) {
        List<Computer> computers= service.getAllComputers();
        model.addAttribute("list", computers);
        model.addAttribute("message", message);
        return "allComputersPage";
    }
    @GetMapping("/edit")
    public String getEditPage(
            Model model, RedirectAttributes attributes,
            @RequestParam Long id
    ) {
        String page = null;
        try {
            Computer computer = service.getComputerById(id);
            model.addAttribute("computer", computer);
            page="editComputerPage";
        } catch (NullPointerException e) {
            e.printStackTrace();
            attributes.addAttribute("message", e.getMessage());
            page="redirect:getAllComputers";
        }
        return page;
    }
    @PostMapping("/update")
    public String updateComputer(
            @ModelAttribute Computer computer,
            RedirectAttributes attributes
    ) {
        service.updateComputer(computer);
        Long id = (long) computer.getId();
        attributes.addAttribute("message", "Computer with id: '"+id+"' is updated successfully !");
        return "redirect:getAllComputers";
    }
    @GetMapping("/delete")
    public String deleteComputer(
            @RequestParam Long id,
            RedirectAttributes attributes
    ) {
        try {
            service.deleteComputerById(id);
            attributes.addAttribute("message", "Computer with Id : '"+id+"' is removed successfully!");
        } catch (NullPointerException e) {
            e.printStackTrace();
            attributes.addAttribute("message", e.getMessage());
        }
        return "redirect:getAllComputers";
    }

}
