package Paquete;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Table(name = "prestamo")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Paquete.Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ejemplar_id", nullable = false)
    private Ejemplar ejemplar;

    @Column(name = "fechaInicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fechaDevolucion")
    private LocalDate fechaDevolucion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paquete.Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Paquete.Usuario usuario) {
        this.usuario = usuario;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaDevolucion() {
        return Validaciones.calcularFechaDevolucion(fechaInicio);
    }

    public void setFechaDevolucion() {
        this.fechaDevolucion = Validaciones.calcularFechaDevolucion(this.fechaInicio);
    }

    //Constructor
    //Sin id porque es autoincrement
    //Sin fecha de devolución porque se tiene que calcular sola 15 días
    //Sin la fecha de inicio para que se cree sola
    public Prestamo(Usuario usuario, Ejemplar ejemplar) {
        //Usar el método de si está penalizado para ver si se puede hacer un préstamo o no
        if (Validaciones.puedeMásPrestamos(usuario)) {
            this.usuario = usuario;
            this.ejemplar = ejemplar;
            this.fechaInicio = LocalDate.now();
            this.fechaDevolucion = getFechaDevolucion();
        }
    }
    //Con fecha de devolución por si el usuario no devuelve el libro, que se pueda actualizar la fecha y se le penalice 15 días
    //Con la fecha de inicio por si se quiere poner manual
    public Prestamo(Usuario usuario, Ejemplar ejemplar, LocalDate fechaInicio, LocalDate fechaDevolucion) {
        if(Validaciones.puedeMásPrestamos(usuario)) {
            this.usuario = usuario;
            this.ejemplar = ejemplar;
            this.fechaInicio = fechaInicio;
            this.fechaDevolucion = fechaDevolucion;
        }
    }

    public Prestamo() {
    }

    //To String
    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", ejemplar=" + ejemplar +
                ", fechaInicio=" + fechaInicio +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }
}