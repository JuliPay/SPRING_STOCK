package gestion_productos.prueba.Entidad;

import jakarta.persistence.*;

@Entity
public class Permisos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private Roles rol;
}
