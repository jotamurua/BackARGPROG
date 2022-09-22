/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.murua.Service;

import com.proyectofinal.murua.Entity.Perfil;
import com.proyectofinal.murua.Repository.RPerfil;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joel
 */
@Service
@Transactional
public class SPerfil {
    @Autowired
    RPerfil rPerfil;
    
    public List<Perfil> list(){
        return rPerfil.findAll();
    }
    public Optional<Perfil> getOne(int id){
        return rPerfil.findById(id);
    }
    public Optional<Perfil> getByNombre(String nombre){
        return rPerfil.findByNombre(nombre);
    }
    public void save(Perfil perfil){
    rPerfil.save(perfil);
    }
    
    public void delete(int id){
        rPerfil.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rPerfil.existsById(id);
    }
    
    
}
