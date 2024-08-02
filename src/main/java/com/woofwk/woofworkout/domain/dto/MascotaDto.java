package com.woofwk.woofworkout.domain.dto;

import com.woofwk.woofworkout.models.Usuario;
import com.woofwk.woofworkout.models.Mascota.Esterilizado;
import com.woofwk.woofworkout.models.Mascota.Sex;
import com.woofwk.woofworkout.models.Mascota.Tipo;


public class MascotaDto {
  // Variables de la clase
    private Integer id_mascota;
    private Tipo tipo_mascota;
    private String nombre;
    private String edad;
    private String raza;
    private Double peso;
    private String tamano;
    private Sex sexo;
    private Esterilizado esterilizado;
    private String descripcion_mascota;
    private String info_cuidado;
    private String foto_mascota;
    private Usuario usuario;


    public Integer getId_mascota() {
        return id_mascota;
    }
    public void setId_mascota(Integer id_mascota) {
        this.id_mascota = id_mascota;
    }
    public Tipo getTipo_mascota() {
        return tipo_mascota;
    }
    public void setTipo_mascota(Tipo tipo_mascota) {
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
    public Double getPeso() {
        return peso;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    public String getTamano() {
        return tamano;
    }
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }
    public Sex getSexo() {
        return sexo;
    }
    public void setSexo(Sex sexo) {
        this.sexo = sexo;
    }
    public Esterilizado getEsterilizado() {
        return esterilizado;
    }
    public void setEsterilizado(Esterilizado esterilizado) {
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
