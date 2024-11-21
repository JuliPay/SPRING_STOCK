package gestion_productos.prueba.Repositorios;

import gestion_productos.prueba.Entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    Optional<Object> findByNombreUsuario(String nombreUsuario);
}
