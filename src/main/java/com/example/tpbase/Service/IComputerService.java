package com.example.tpbase.Service;

import com.example.tpbase.model.Computer;

import java.util.List;

public interface IComputerService {

    public Computer saveComputer(Computer computer);
    public List<Computer> getAllComputers();
    public Computer getComputerById(Long id);
    public void deleteComputerById(Long id);
    public void updateComputer(Computer computer);

}
