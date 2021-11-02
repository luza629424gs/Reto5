/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.reto3.repositorio;

import com.reto3.reto3.interfaces.interfaceReservation;
import com.reto3.reto3.tablas.Cliente;
import com.reto3.reto3.tablas.Reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class repositorioReservation {
    
    @Autowired
    private interfaceReservation crud4;

    public List<Reservation> getAll(){
        return (List<Reservation>) crud4.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return crud4.findById(id);
    }
    public Reservation save(Reservation reservacion){
        return crud4.save(reservacion);
    }
    public void delete(Reservation reservacion){
        crud4.delete(reservacion);
    }

    public List<Reservation> ReservacionStatusRepositorio (String status){
        return crud4.findAllByStatus(status);
    }

    public List<Reservation> ReservacionTiempoRepositorio (Date a, Date b){
        return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);}

    public List<ContadorClientes> getClientesRepositorio(){

        List<ContadorClientes> res = new ArrayList<>();
        List<Object[]> report = crud4.countTotalReservationsByCliente();
        for(int i=0; i<report.size(); i++){
            res.add(new ContadorClientes((Long)report.get(i)[1],
                    (Cliente) report.get(i)[0]));
        }
        return res;
    }
}
