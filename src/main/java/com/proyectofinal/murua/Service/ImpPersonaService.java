/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.murua.Service;

import com.proyectofinal.murua.Entity.Experiencia;
import com.proyectofinal.murua.Entity.Persona;
import com.proyectofinal.murua.Interface.IPersonaService;
import com.proyectofinal.murua.Repository.IPersonaRepository;
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
public class ImpPersonaService implements IPersonaService{
    @Autowired IPersonaRepository ipersonaRepository;
    
    public boolean existsById(int id){
        return ipersonaRepository.existsById(id);
    }
        public Optional<Experiencia> getOne(int id){
        return ipersonaRepository.findById(id);
    }
    
    @Override
    public List<Persona> getPersona() {
    List<Persona> persona = ipersonaRepository.findAll();
    return persona;
    }


    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
        
    }
    
}
