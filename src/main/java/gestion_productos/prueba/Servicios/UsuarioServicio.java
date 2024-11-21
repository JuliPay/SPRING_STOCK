package gestion_productos.prueba.Servicios;

import gestion_productos.prueba.DTOs.UsuarioCreateDTO;
import gestion_productos.prueba.Entidad.Roles;
import gestion_productos.prueba.Entidad.Usuario;
import gestion_productos.prueba.Repositorios.RolesRepositorio;
import gestion_productos.prueba.Repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private RolesRepositorio rolesRepository;

    public Map<String, String> crearUsuario(UsuarioCreateDTO dto) {
        // Validar existencia del rol
        Roles rol = rolesRepository.findById(dto.getRolId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El rol especificado no existe"));

        // Encriptar contraseña
        String contraseñaEncriptada = BCrypt.hashpw(dto.getContraseña(), BCrypt.gensalt());

        // Crear usuario
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(dto.getNombreUsuario());
        usuario.setDocumento(dto.getDocumento());
        usuario.setCorreoElectronico(dto.getCorreoElectronico());
        usuario.setContraseña(contraseñaEncriptada);
        usuario.setRol(rol);
        usuario.setEmprendimiento(dto.getNombreEmprendimiento());

        usuarioRepositorio.save(usuario);

        return Map.of("msg", "Usuario creado exitosamente");
    }
}
