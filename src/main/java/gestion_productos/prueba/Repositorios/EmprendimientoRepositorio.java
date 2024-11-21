package gestion_productos.prueba.Repositorios;

import gestion_productos.prueba.Entidad.Emprendimiento;
import gestion_productos.prueba.Entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprendimientoRepositorio extends JpaRepository<Emprendimiento, Integer> {
    boolean existsByDocumento(String documento);

    boolean existsByNombreEmprendimiento(String nombreEmprendimiento);
}
