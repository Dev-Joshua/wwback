package com.woofwk.woofworkout.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mascotas")
public class Mascota {

    @Id
    private Long id_mascota;
    
    private String tipo_mascota;
    private String nombre;
    private String edad;
    private String raza;
    private Float peso;
    private String tamano;
    private String sexo;
    private String esterilizado;
    private String descripcion_mascota;
    private String info_cuidado;
    private String foto_mascota;
    

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


    public Long getId_mascota() {
        return id_mascota;
    }


    public void setId_mascota(Long id_mascota) {
        this.id_mascota = id_mascota;
    }


    public String getTipo_mascota() {
        return tipo_mascota;
    }


    public void setTipo_mascota(String tipo_mascota) {
        this.tipo_mascota = tipo_mascota;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getEdad() {
        return edad;
    }


    public void setEdad(String edad) {
        this.edad = edad;
    }


    public String getRaza() {
        return raza;
    }


    public void setRaza(String raza) {
        this.raza = raza;
    }


    public Float getPeso() {
        return peso;
    }


    public void setPeso(Float peso) {
        this.peso = peso;
    }


    public String getTamano() {
        return tamano;
    }


    public void setTamano(String tamano) {
        this.tamano = tamano;
    }


    public String getSexo() {
        return sexo;
    }


    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    public String getEsterilizado() {
        return esterilizado;
    }


    public void setEsterilizado(String esterilizado) {
        this.esterilizado = esterilizado;
    }


    public String getDescripcion_mascota() {
        return descripcion_mascota;
    }


    public void setDescripcion_mascota(String descripcion_mascota) {
        this.descripcion_mascota = descripcion_mascota;
    }


    public String getInfo_cuidado() {
        return info_cuidado;
    }


    public void setInfo_cuidado(String info_cuidado) {
        this.info_cuidado = info_cuidado;
    }


    public String getFoto_mascota() {
        return foto_mascota;
    }


    public void setFoto_mascota(String foto_mascota) {
        this.foto_mascota = foto_mascota;
    }


    public Usuario getUsuario() {
        return usuario;
    }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    

    
}
