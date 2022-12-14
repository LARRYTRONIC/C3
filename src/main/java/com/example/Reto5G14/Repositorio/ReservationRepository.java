/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Reto5G14.Repositorio;

import com.example.Reto5G14.Interface.ReservationInterface;
import com.example.Reto5G14.Modelo.Client;
import com.example.Reto5G14.Modelo.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository

public class ReservationRepository {
      @Autowired
    private ReservationInterface extensionesCrud;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) extensionesCrud.findAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return extensionesCrud.findById(id);
    }
    
    public Reservation save (Reservation reservation){
        return extensionesCrud.save(reservation);
    } 
    
    public void delete(Reservation reservation){
        extensionesCrud.delete(reservation);
    }

    
    ///////Reto5 ////////
    
    public List <Reservation> getReservationByStatus (String status){
        return extensionesCrud.findAllByStatus(status);
    }
   
    public List<Reservation> informePeriodoTiempoReservas(Date a, Date b){
        return extensionesCrud.findAllByStartDateAfterAndStartDateBefore(a,b);
    }
    
    public List<CountClient> getTopClient(){
        List<CountClient> res= new ArrayList<>();
        List<Object[]> report = extensionesCrud.countTotalReservationByClient();
        for(int i=0;i<report.size();i++){
            res.add(new CountClient((Long)report.get(i)[1],(Client) report.get(i)[0]));
        }
        return res;
    }

}

