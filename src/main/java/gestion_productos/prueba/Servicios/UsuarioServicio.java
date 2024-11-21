package gestion_productos.prueba.Servicios;

import gestion_productos.prueba.DTOs.UsuarioCreateDTO;
import gestion_productos.prueba.DTOs.UsuarioDTO;
import gestion_productos.prueba.DTOs.UsuarioUpdateDTO;
import gestion_productos.prueba.Entidad.Roles;
import gestion_productos.prueba.Entidad.Usuario;
import gestion_productos.prueba.Repositorios.RolesRepositorio;
import gestion_productos.prueba.Repositorios.UsuarioRepositorio;
import gestion_productos.prueba.Seguridad.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private RolesRepositorio rolesRepositorio;

    public Map<String, String> crearUsuario(UsuarioCreateDTO dto) {
        // Validar existencia del rol
        Roles rol = rolesRepositorio.findById(dto.getRolId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El rol especificado no existe"));

        // Encriptar contraseña
        String contraseñaEncriptada = PasswordUtil.hashPassword(dto.getContraseña());

        // Crear usuario
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(dto.getNombreUsuario());
        usuario.setDocumento(dto.getDocumento());
        usuario.setCorreoElectronico(dto.getCorreoElectronico());
        usuario.setContraseña(contraseñaEncriptada);
        usuario.setRol(rol);
        usuario.setEmprendimiento(dto.getNombreEmprendimiento);

        usuarioRepositorio.save(usuario);

        return Map.of("msg", "Usuario creado exitosamente");
    }

    // Actualizar usuario
    public Map<String, String> actualizarUsuario(Integer id, UsuarioUpdateDTO dto) {
        Usuario usuario = usuarioRepositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        if (dto.getNombreUsuario() != null) {
            usuario.setNombreUsuario(dto.getNombreUsuario());
        }
        if (dto.getDocumento() != null) {
            usuario.setDocumento(dto.getDocumento);
        }
        if (dto.getCorreoElectronico() != null) {
            usuario.setCorreoElectronico(dto.getCorreoElectronico());
        }
        if (dto.getContraseña() != null) {
            String contraseñaEncriptada = PasswordUtil.hashPassword(dto.getContraseña());
            Usuario.setContraseña(contraseñaEncriptada);
        }
        if (dto.getRolId() != null) {
            Roles rol = rolesRepositorio.findById(dto.getRolId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol no encontrado"));
            usuario.setRol(rol);
        }

        usuarioRepositorio.save(usuario);
        return Map.of("msg", "Usuario actualizado exitosamente");
    }

    // Eliminar usuario
    public Map<String, String> eliminarUsuario(Integer id, String contraseña) {
        Usuario usuario = usuarioRepositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        if (!contraseña.equals("1234")) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Contraseña incorrecta");
        }

        usuarioRepositorio.delete(usuario);
        return Map.of("msg", "Usuario eliminado exitosamente");
    }

    // Consultar usuarios
    public List<UsuarioDTO> consultarUsuarios() {
        List<Usuario> usuarios = usuarioRepositorio.findAll();

        return List.of();
    }

}
