package com.woofwk.woofworkout.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicios")
public class Servicio {
    
    //Variables
    @Id
    private Long id_servicio;

    private String nombre_servicio;

    private String descripcion;
    private Float precio;

    @ManyToMany(mappedBy = "servicios")
    @JsonBackReference("usuario-servicio")
    private Set<Usuario> usuarios = new HashSet<>();

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("servicio-solicitud")
    private Set<Solicitud> solicitudes = new HashSet<>();
    
    // Getters & Setters
    
    public Long getId_servicio() {
        return id_servicio;
    }

    public Set<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(Set<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public void setId_servicio(Long id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    // public Usuario getUsuario() {
    //     return usuario;
    // }

    // public void setUsuario(Usuario usuario) {
    //     this.usuario = usuario;
    // }

}
