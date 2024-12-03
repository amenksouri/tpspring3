package com.example.tpbase.Service;

import com.example.tpbase.model.Departement;

import java.util.List;

public interface IDepartementService {
    public Departement saveDepartement(Departement departement);
    public List<Departement> getAllDepartements();
    public Departement getDepartementById(Long id);
    public void deleteDepartementById(Long id);
    public void updateDepartement(Departement departement);

}
