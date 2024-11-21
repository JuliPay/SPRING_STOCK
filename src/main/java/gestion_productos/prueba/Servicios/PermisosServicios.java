package gestion_productos.prueba.Servicios;

import gestion_productos.prueba.Entidad.Permisos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermisosServicios {
    @Autowired
    private PermisosRepositorio permisoRepositorio;

    // Crear un nuevo permiso
    public Permisos crearPermiso(Permisos permiso) {
        return permisoRepositorio.save(permiso);
    }

    // Obtener todos los permisos
    public List<Permisos> obtenerPermisos() {
        return permisoRepositorio.findAll();
    }

    // Buscar permiso por ID
    public Optional<Permisos> obtenerPermisoPorId(Long id) {
        return permisoRepositorio.findById(id);
    }
}
