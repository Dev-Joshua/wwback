package com.woofwk.woofworkout.web.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woofwk.woofworkout.domain.service.MascotaService;
import com.woofwk.woofworkout.domain.service.PagoService;
import com.woofwk.woofworkout.domain.service.ServicioService;
import com.woofwk.woofworkout.domain.service.SolicitudService;
import com.woofwk.woofworkout.domain.service.UsuarioService;
import com.woofwk.woofworkout.models.Mascota;
import com.woofwk.woofworkout.models.Pago;
import com.woofwk.woofworkout.models.Servicio;
import com.woofwk.woofworkout.models.Solicitud;
import com.woofwk.woofworkout.models.Usuario;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {
    @Autowired
    private SolicitudService requestService;

    @Autowired
    private UsuarioService userService;

    @Autowired
    private MascotaService petService;

    @Autowired
    private ServicioService serviceService;

    // @Autowired
    // private PagoService pagoService;

    // Metodos
    @GetMapping
    public List<Solicitud> getAllRequests() {
        return requestService.getAll();
    }

    @GetMapping("/{id}")
    public Solicitud getRequestById(@PathVariable Long id) {
        return requestService.findByIdRequest(id);
    }

    @PostMapping("/{usuarioId}")
    public ResponseEntity<Solicitud> createQuery(
            @PathVariable Long usuarioId,
            @RequestBody Map<String, Object> requestPayLoad) {
        
        Usuario user = userService.getUserById(usuarioId);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Long mascotaId = ((Number) requestPayLoad.get("mascota_id")).longValue();
        Mascota mascota = petService.getPetById(mascotaId);
        if (mascota == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Long servicioId = ((Number) requestPayLoad.get("servicio_id")).longValue();
        Servicio servicio = serviceService.findById(servicioId);
        if (servicio == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Solicitud request = new Solicitud();
        request.setFecha_solicitud(LocalDateTime.now());
        // request.setUsuario(user);
        request.setServicio(servicio);
        request.setMascota(mascota);
        request.setEstado((String) requestPayLoad.get("estado"));

      
        // Map<String, Object> paymentLoad = (Map<String, Object>) requestPayLoad.get("pago");
        // Pago pay = new Pago();
        // pay.setMonto(((Number) paymentLoad.get("monto")).floatValue());
        // pay.setFechaPago(LocalDateTime.now());

        Pago pay = new Pago();
        pay.setMonto(servicio.getPrecio());
        pay.setFechaPago(LocalDateTime.now());

        request.setPago(pay);

        Solicitud newRequest = requestService.createRequest(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(newRequest);
    }
    // public Solicitud createRequest(@RequestBody Solicitud solicitud) {
    //     return requestService.createRequest(solicitud);
    // }

    // @DeleteMapping("/{id}")
    // public void deleteSolicitud(@PathVariable Long id) {
    //     solicitudService.deleteById(id);
    // }
}
