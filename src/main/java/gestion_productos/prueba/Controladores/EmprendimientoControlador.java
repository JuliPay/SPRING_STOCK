package gestion_productos.prueba.Controladores;

import gestion_productos.prueba.DTOs.EmprendimientoResponseDTO;
import gestion_productos.prueba.DTOs.RegistrarseDTO;
import gestion_productos.prueba.Servicios.EmprendimientoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class EmprendimientoControlador {
    @Autowired
    private EmprendimientoServicio emprendimientoServicio;

    @PostMapping
    public ResponseEntity<EmprendimientoResponseDTO> registrarEmprendimiento(@RequestBody RegistrarseDTO dto) {
        EmprendimientoResponseDTO response = emprendimientoServicio.registrarEmprendimiento(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
