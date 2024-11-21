package gestion_productos.prueba.Entidad;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Registrate")
public class Emprendimiento {
    @Id
    @Column(name = "documento", length = 30)
    private String documento;

    @Column(name = "nombreEmprendimiento", unique = true,nullable = false, length = 50)
    private String nombreEmprendimiento;

    @Column(name = "tipoEmprendimiento", nullable = false, length = 50)
    private String tipoEmprendimiento;

    @Column(name = "numeroEmpleados")
    private Integer numeroEmpleados;

    @Column(name = "nombreRegistro", unique = true, nullable = false, length = 50)
    private String nombreRegistro;

    @Column(name = "correoElectronico", unique = true, nullable = false, length = 50)
    private String correoElectronico;

    @Column(name = "contraseña", nullable = false, length = 150)
    private String contraseña;

    @Column(name = "rol", nullable = false, length = 30)
    private String rol;

    @OneToMany(mappedBy = "emprendimiento", cascade = CascadeType.ALL)
    private List<Usuario> usuarios;


    public String getNombreEmprendimiento() {
        return nombreEmprendimiento;
    }

    public void setNombreEmprendimiento(String nombreEmprendimiento) {
        this.nombreEmprendimiento = nombreEmprendimiento;
    }

    public String getTipoEmprendimiento() {
        return tipoEmprendimiento;
    }

    public void setTipoEmprendimiento(String tipoEmprendimiento) {
        this.tipoEmprendimiento = tipoEmprendimiento;
    }

    public Integer getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(Integer numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }

    public String getNombreRegistro() {
        return nombreRegistro;
    }

    public void setNombreRegistro(String nombreRegistro) {
        this.nombreRegistro = nombreRegistro;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setDocumento(String documento) {
    }
}
