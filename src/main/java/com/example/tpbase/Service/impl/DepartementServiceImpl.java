package com.example.tpbase.Service.impl;

import com.example.tpbase.Service.IDepartementService;
import com.example.tpbase.model.Departement;
import com.example.tpbase.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementServiceImpl  implements IDepartementService {
    @Autowired
    DepartementRepository departementrepo;
    @Override
    public Departement saveDepartement(Departement departement) {
// TODO Auto-generated method stub
        return departementrepo.save(departement);
    }
    @Override
    public List<Departement> getAllDepartements() {
// TODO Auto-generated method stub
        return (List<Departement>) departementrepo.findAll();
    }
    @Override
    public Departement getDepartementById(Long id) {
    // TODO Auto-generated method stub
        Optional<Departement> op = departementrepo.findById(id);
        if(op.isPresent())
        {
            return op.get();
        }
        else
        {
            throw new NullPointerException("Departement avec l'Id "+ id +"n'existe pas");
        }
    }
    @Override
    public void deleteDepartementById(Long id) {
    // TODO Auto-generated method stub
        departementrepo.delete(getDepartementById(id));
    }
    @Override
    public void updateDepartement(Departement departement) {
    // TODO Auto-generated method stub
        departementrepo.save(departement);
    }

}
