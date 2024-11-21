package gestion_productos.prueba.Servicios;

import gestion_productos.prueba.DTOs.RolCreateDTO;
import gestion_productos.prueba.Entidad.Roles;
import gestion_productos.prueba.Repositorios.RolesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RolServicio {
    @Autowired
    private RolesRepositorio rolesRepositorio;

    public RolCreateDTO crearRol(RolCreateDTO rolDTO) {
        // Validar si el rol ya existe
        Optional<Roles> rolExistente = rolesRepositorio.findByNombreRol(rolDTO.getNombreRol());
        if (rolExistente.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El rol ya existe");
        }

        // Crear un nuevo rol
        Roles nuevoRol = new Roles();
        nuevoRol.setNombreRol(rolDTO.getNombreRol());

        rolesRepositorio.save(nuevoRol);

        RolCreateDTO response = new RolCreateDTO();
        response.setNombreRol(nuevoRol.getNombreRol());
        return response;
    }
}
