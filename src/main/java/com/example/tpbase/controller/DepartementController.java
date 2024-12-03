package com.example.tpbase.controller;

import com.example.tpbase.Service.IDepartementService;
import com.example.tpbase.model.Departement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/departement")
public class DepartementController {
    @Autowired
    IDepartementService service;
    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }
    @GetMapping("/ajouter")
    public String showAddDepartement() {
        return "ajoutdepartementPage";
    }
    @PostMapping("/save")
    public String saveDepartement(
            @ModelAttribute Departement departement,
            Model model
    ) {
        service.saveDepartement(departement);
        Long id = (long)
                service.saveDepartement(departement).getId();
        String message = "Record with id : '"+id+"' is saved successfully !";
        model.addAttribute("message", message);
        return "ajoutdepartementPage";
    }
    @GetMapping("/getAllDepartements")
    public String getAllDepartements(
            @RequestParam(value = "message", required = false)
            String message,Model model
    ) {
        List<Departement> departements= service.getAllDepartements();
        model.addAttribute("list", departements);
        model.addAttribute("message", message);
        return "allDepartementsPage";
    }
    @GetMapping("/edit")
    public String getEditPage(
            Model model,
            RedirectAttributes attributes,
            @RequestParam Long id
    ) {
        String page = null;
        try {
            Departement departement = service.getDepartementById(id);
            model.addAttribute("departement", departement);
            page="editDepartementPage";
        } catch (NullPointerException e) {
            e.printStackTrace();
            attributes.addAttribute("message", e.getMessage());
            page="redirect:getAllDepartements";
        }
        return page;
    }
    @PostMapping("/update")
    public String updateDepartement(
            @ModelAttribute Departement departement,
            RedirectAttributes attributes
    ) {
        service.updateDepartement(departement);
        Long id = (long) departement.getId();
        attributes.addAttribute("message", "Departement with id:'"+id+"' is updated successfully !");
        return "redirect:getAllDepartements";
    }
    @GetMapping("/delete")
    public String deleteDeparetement(
            @RequestParam Long id,
            RedirectAttributes attributes
    ) {
        try {
            service.deleteDepartementById(id);
            attributes.addAttribute("message", "Departement with Id : '"+id+"' is removed successfully!");
        } catch (NullPointerException e) {
            e.printStackTrace();
            attributes.addAttribute("message", e.getMessage());
        }
        return "redirect:getAllDepartements";
    }

}
