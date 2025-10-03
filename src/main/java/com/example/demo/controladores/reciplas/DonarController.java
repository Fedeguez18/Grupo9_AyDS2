package com.example.demo.controladores.reciplas;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.resiplas.DonarPlastico;
import com.example.demo.servicio.reciplas.DonarService;

@RestController
public class DonarController {
   
    private final DonarService donarService;

    public DonarController(DonarService donarService){
        this.donarService = donarService;
    }
    
    @PostMapping("/donar")
    //@ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> guardarDonacion(@RequestBody DonarPlastico donacion){
        
        DonarPlastico guardado= donarService.guardarDonacion(donacion);
        
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Donación guardada exitosamente");
        response.put("idDonacion", guardado.getIdDonacion());
        response.put("idUsuario", guardado.getIdUsuario());
        response.put("cantidad", guardado.getCantidadADonar() + " " + guardado.getUnidad());
        
        return response;
    }
   
}

/*
 {
  "idUsuario": 1,
  "idPlastico": 10,
  "cantidadADonar": 10,
  "fechaHoraDisp": "2025-10-03",
  "descipcion": "botellas de gaceosas",
  "direccion": "calle 13 y 120",
  "buscar": 1,
  "unidad": "kg"
}
 */