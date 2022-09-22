/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectofinal.murua.Repository;

import com.proyectofinal.murua.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Joel
 */
public interface RProyectos extends JpaRepository<Proyectos, Integer>{
   Optional<Proyectos> findByNombre(String nombre);
   public boolean existsByNombre(String nombre);
}
