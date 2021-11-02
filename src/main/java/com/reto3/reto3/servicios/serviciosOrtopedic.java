package com.reto3.reto3.servicios;

import com.reto3.reto3.repositorio.repositorioOrtopedic;
import com.reto3.reto3.tablas.Ortopedic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class serviciosOrtopedic {

    @Autowired
    private repositorioOrtopedic crudServicios;

    public List<Ortopedic> getAll(){
        return crudServicios.getAll();

    }
    public Optional<Ortopedic> getOrtopedic(int ortopedicId) {
        return crudServicios.getOrtopedic(ortopedicId);
    }
    public Ortopedic save(Ortopedic ortopedic) {
        if (ortopedic.getId() == null) {
            return crudServicios.save(ortopedic);
        } else {
            Optional<Ortopedic> e = crudServicios.getOrtopedic(ortopedic.getId());
            if (e.isEmpty()) {
                return crudServicios.save(ortopedic);
            } else {
                return ortopedic;
            }
        }
    }

    public Ortopedic update(Ortopedic ortopedic){
        if(ortopedic.getId()!=null){
            Optional<Ortopedic> e=crudServicios.getOrtopedic(ortopedic.getId());
            if(!e.isEmpty()){
                if(ortopedic.getName()!=null){
                    e.get().setName(ortopedic.getName());
                }
                if(ortopedic.getBrand()!=null){
                    e.get().setBrand(ortopedic.getBrand());
                }
                if(ortopedic.getYear()!=null){
                    e.get().setYear(ortopedic.getYear());
                }
                if(ortopedic.getDescription()!=null){
                    e.get().setDescription(ortopedic.getDescription());
                }
                if(ortopedic.getCategory()!=null){
                    e.get().setCategory(ortopedic.getCategory()); //CAMBIO
                }
                crudServicios.save(e.get());
                return e.get();
            }else{
                return ortopedic;
            }
        }else{
            return ortopedic;
        }
    }

    public boolean deleteOrtopedic(int ortopedicId) {
        Boolean aBoolean = getOrtopedic(ortopedicId).map(ortopedic -> {
            crudServicios.delete(ortopedic);
            return true;
        }).orElse(false);
        return aBoolean;
    }


}
