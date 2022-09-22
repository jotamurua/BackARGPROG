/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.murua.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Joel
 */
public class dtoPerfil {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String ubicacion;
    @NotBlank
    private String titulo;
    @NotBlank
    private String acercade;
    @NotBlank
    private String img;
    @NotBlank
    private String banner;

    public dtoPerfil() {
    }

    public dtoPerfil(String nombre, String apellido, String ubicacion, String titulo, String acercade, String img, String banner) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ubicacion = ubicacion;
        this.titulo = titulo;
        this.acercade = acercade;
        this.img = img;
        this.banner = banner;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAcercade() {
        return acercade;
    }

    public void setAcercade(String acercade) {
        this.acercade = acercade;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }
    
    
}
