/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectofinal.murua.Repository;

import com.proyectofinal.murua.Entity.Perfil;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Joel
 */
@Repository
public interface RPerfil extends JpaRepository<Perfil, Integer> {
    public Optional<Perfil> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
