package gestion_productos.prueba.Repositorios;

import gestion_productos.prueba.Entidad.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {
}
