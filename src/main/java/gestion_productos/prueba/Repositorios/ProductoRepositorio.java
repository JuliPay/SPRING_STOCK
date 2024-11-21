package gestion_productos.prueba.Repositorios;

import gestion_productos.prueba.Entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
}
