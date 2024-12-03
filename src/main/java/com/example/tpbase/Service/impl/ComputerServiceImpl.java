package com.example.tpbase.Service.impl;

import com.example.tpbase.Service.IComputerService;
import com.example.tpbase.model.Computer;
import com.example.tpbase.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ComputerServiceImpl implements IComputerService {

    @Autowired
    ComputerRepository computerrepo;
    @Override
    public Computer saveComputer(Computer computer) {
// TODO Auto-generated method stub
        return computerrepo.save(computer);
    }
    @Override
    public List<Computer> getAllComputers() {
        // TODO Auto-generated method stub
        return (List<Computer>)computerrepo.findAll();
    }
    @Override
    public Computer getComputerById(Long id) {
    // TODO Auto-generated method stub
        Optional<Computer> op = computerrepo.findById(id);
        if(op.isPresent())
        {
            return op.get();
        }
        else
        {
            throw new NullPointerException("computer avec l'Id "+ id +"n'existe pas");
        }
    }
    @Override
    public void deleteComputerById(Long id) {
// TODO Auto-generated method stub
        computerrepo.delete(getComputerById(id));
    }
    @Override
    public void updateComputer(Computer computer) {
// TODO Auto-generated method stub
        computerrepo.save(computer);
    }

}
