package com.reto3.reto3.repositorio;

import com.reto3.reto3.interfaces.interfaceOrtopedic;
import com.reto3.reto3.tablas.Ortopedic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class repositorioOrtopedic {

    @Autowired
    private interfaceOrtopedic crudOrtopedic;

    public List<Ortopedic> getAll() {
        return (List<Ortopedic>) crudOrtopedic.findAll();
    }


    public Optional<Ortopedic> getOrtopedic(int id) {
        return crudOrtopedic.findById(id);
    }

    public Ortopedic save(Ortopedic ortopedic){
        return crudOrtopedic.save(ortopedic);
    }

    public void delete(Ortopedic ortopedic){
        crudOrtopedic.delete(ortopedic);
    }


}
