/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectofinal.murua.Repository;

import com.proyectofinal.murua.Entity.Experiencia;
import com.proyectofinal.murua.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Joel
 */
@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {

    public boolean existsById(int id);

    public Optional<Experiencia> findById(int id);
    
}
