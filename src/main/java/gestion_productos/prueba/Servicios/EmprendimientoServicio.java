package gestion_productos.prueba.Servicios;

import gestion_productos.prueba.DTOs.EmprendimientoResponseDTO;
import gestion_productos.prueba.DTOs.RegistrarseDTO;
import gestion_productos.prueba.Entidad.Emprendimiento;
import gestion_productos.prueba.Repositorios.EmprendimientoRepositorio;
import gestion_productos.prueba.Seguridad.PasswordUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class EmprendimientoServicio {
    @Autowired
    private EmprendimientoRepositorio emprendimientoRepository;

    public EmprendimientoResponseDTO registrarEmprendimiento(RegistrarseDTO dto) {
        // Validar nombre de emprendimiento único
        if (emprendimientoRepository.existsByNombreEmprendimiento(dto.getNombreEmprendimiento())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre del emprendimiento ya existe");
        }

        // Validar documento único
        if (emprendimientoRepository.existsByDocumento(dto.getDocumento())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El documento ya está registrado");
        }

        // Encriptar la contraseña
        String contraseñaEncriptada = PasswordUtil.hashPassword(dto.getContraseña());

        // Crear la entidad y guardarla
        Emprendimiento emprendimiento = new Emprendimiento();
        emprendimiento.setNombreEmprendimiento(dto.getNombreEmprendimiento());
        emprendimiento.setTipoEmprendimiento(dto.getTipoEmprendimiento());
        emprendimiento.setNumeroEmpleados(dto.getNumeroEmpleados());
        emprendimiento.setNombreRegistro(dto.getNombreRegistro());
        emprendimiento.setDocumento(dto.getDocumento());
        emprendimiento.setCorreoElectronico(dto.getCorreoElectronico());
        emprendimiento.setContraseña(contraseñaEncriptada);
        emprendimiento.setRol(dto.getRol());

        emprendimientoRepository.save(emprendimiento);

        // Preparar la respuesta
        EmprendimientoResponseDTO response = new EmprendimientoResponseDTO();
        BeanUtils.copyProperties(emprendimiento, response); // Copia las propiedades
        return response;
    }
}
