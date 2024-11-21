package gestion_productos.prueba.Entidad;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_usuario", nullable = false, unique = true, length = 50)
    private String nombreUsuario;

    @Column(name = "documento", nullable = false, unique = true, length = 25)
    private String documento;

    @Column(name = "correoElectronico", nullable = false, unique = true, length = 50)
    private String correoElectronico;

    @Column(name = "contraseña", nullable = false, length = 100)
    private String contraseña;

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private Roles rol;

    @ManyToOne
    @JoinColumn(name = "nombreEmprendimiento",referencedColumnName = "nombreEmprendimiento", nullable = false)
    private Emprendimiento emprendimiento;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Producto> productos;

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public static String setContraseña(String contraseña) {
        return contraseña ;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public Emprendimiento getEmprendimiento() {
        return emprendimiento;
    }

    public void setEmprendimiento(Emprendimiento emprendimiento) {
        this.emprendimiento = emprendimiento;
    }
}
