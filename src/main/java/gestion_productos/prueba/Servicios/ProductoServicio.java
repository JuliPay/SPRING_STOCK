package gestion_productos.prueba.Servicios;

import gestion_productos.prueba.Entidad.Producto;
import gestion_productos.prueba.Repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {
    @Autowired
    private ProductoRepositorio productoRepositorio;

    public List<Producto> obtenerTodos() {
        return productoRepositorio.findAll();
    }

    public Optional<Producto> obtenerPorId(Integer id) {
        return productoRepositorio.findById(id);
    }

    public Producto crearProducto(Producto producto) {

        return productoRepositorio.save(producto);
    }

    public Producto actualizarProducto(Integer id, Producto productoDetalles) {
        Producto producto = productoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto.setNombreProducto(productoDetalles.getNombreProducto());
        producto.setDescripcion(productoDetalles.getDescripcion());
        producto.setCantidad(productoDetalles.getCantidad());
        producto.setPrecio(productoDetalles.getPrecio());

        return productoRepositorio.save(producto);
    }

    public void eliminarProducto(Integer id) {
        productoRepositorio.deleteById(id);
    }
}
