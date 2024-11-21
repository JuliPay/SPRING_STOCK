package gestion_productos.prueba.Controladores;

import gestion_productos.prueba.DTOs.RolCreateDTO;
import gestion_productos.prueba.Servicios.RolServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RolesControlador {
    @Autowired
    private RolServicio rolesServicio; // El servicio debe estar implementado para manejar la lógica de negocios

    @PostMapping
    public ResponseEntity<RolCreateDTO> crearRol(@Valid @RequestBody RolCreateDTO rolDTO) {
        RolCreateDTO response = rolesServicio.crearRol(rolDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
