package gestion_productos.prueba.Repositorios;

import gestion_productos.prueba.Entidad.Producto;
import gestion_productos.prueba.Entidad.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepositorio extends JpaRepository<Roles, Integer> {
    Optional<Roles> findByNombreRol(String nombreRol);
}
