package gestion_productos.prueba.Controladores;

import gestion_productos.prueba.DTOs.EliminarUsuarioDTO;
import gestion_productos.prueba.DTOs.UsuarioCreateDTO;
import gestion_productos.prueba.DTOs.UsuarioDTO;
import gestion_productos.prueba.DTOs.UsuarioUpdateDTO;
import gestion_productos.prueba.Servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping
    public ResponseEntity<String> crearUsuario(@RequestBody UsuarioCreateDTO usuarioDTO) {
        usuarioServicio.crearUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado exitosamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioUpdateDTO usuarioUpdateDTO) {
        usuarioServicio.actualizarUsuario(id, usuarioUpdateDTO);
        return ResponseEntity.ok("Usuario actualizado exitosamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Integer id, @RequestParam String contraseña) {
        usuarioServicio.eliminarUsuario(id, contraseña);
        return ResponseEntity.ok("Usuario eliminado exitosamente");
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> consultarUsuarios() {
        List<UsuarioDTO> usuarios = usuarioServicio.consultarUsuarios();
        return ResponseEntity.ok(usuarios);
    }
}
