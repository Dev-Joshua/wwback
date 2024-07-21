package com.woofwk.woofworkout.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagos")
public class Pago {

    //Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Long id_pago;

    private Float monto;
    private LocalDateTime fechaPago;

    @OneToOne
    @JoinColumn(name = "solicitud_id")
    @JsonBackReference("pago-solicitud")
    private Solicitud solicitud;
    
    // @ManyToOne
    // @JoinColumn(name = "solicitud_id")
    // private Solicitud solicitud;

    // Getters & Setters
    public Long getId_pago() {
        return id_pago;
    }

    public void setId_pago(Long id_pago) {
        this.id_pago = id_pago;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    
}
