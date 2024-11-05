package com.example.tpbase;

import com.example.tpbase.model.Computer;
import com.example.tpbase.model.Departement;
import com.example.tpbase.model.Employee;
import com.example.tpbase.repository.ComputerRepository;
import com.example.tpbase.repository.DepartementRepository;
import com.example.tpbase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class TpbaseApplication {
    @Autowired
    EmployeeRepository employerepo;
    @Autowired
    ComputerRepository computerRepo;

    @Autowired
    DepartementRepository departrepo;
    public static void main(String[] args) {

        SpringApplication.run(TpbaseApplication.class, args);

    }

        @GetMapping("/listemplyees")
        public List<Employee> getAllEmployee ()
        {
            List<Employee> em = List.of();
            try{
                em = (List<Employee>) employerepo.findAll();}
            catch(Exception e){
                System.out.println("----- > error 2 is : "+e);
            }
            return em;
        }

        @PostMapping("/addemployee")
        public Employee addEmployee(@RequestBody Employee emp)
        {
            return employerepo.save(emp);
        }
        @GetMapping("/listecomputers")
        public List<Computer> getAllComputers()
        {
            return (List<Computer>) computerRepo.findAll();
        }

        @PostMapping("/addcomputer")
        public Computer addComputer(@RequestBody Computer comp)
        {
            return computerRepo.save(comp);
        }

    @GetMapping("/listdepartements")
    public List<Departement> getAllDepartements ()
    {
        List<Departement> em = List.of();
        try{
            em = (List<Departement>) departrepo.findAll();}
        catch(Exception e){
            System.out.println("----- > error 2 is : "+e);
        }
        return em;
    }
    @PostMapping("/adddep")
    public Departement addDepartement(@RequestBody Departement Dept)
    {
        return departrepo.save(Dept);
    }

    @GetMapping("/listemplyeespardepartement/{id}")
    public List<Employee>
    FindByDepartement(@PathVariable("id") long Dept_id)
    {
        return (List<Employee>)
                employerepo.FindByDepartement(Dept_id);
    }



}
