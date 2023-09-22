package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direccion.Direccion;

@Table(name = "medicos")
@Entity(name = "Medico")//Nombre de entidad, la entidad es el objeto del cual es necesario saber los datos
@Getter//Generador de lombok de getter
@NoArgsConstructor//Generador de lombok de Constructor sin argumentos
@AllArgsConstructor//Generador de lombok de Constructor con todos los atributos
@EqualsAndHashCode(of = "id")
public class Medico {
    //Clase usada para mapear los datos y registrar en la base de datos
    //Clase usada para el metodo post para guardar datos en la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean activo;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;

    //Contructor para poder parsear los datos de registro medico en la clase medico y poder usar le metodo save
    public Medico(DatosRegistroMedico datosRegistroMedico) {
        this.activo  = true;
        this.nombre = datosRegistroMedico.nombre();
        this.email = datosRegistroMedico.email();
        this.telefono  = datosRegistroMedico.telefono();
        this.documento = datosRegistroMedico.documento();
        this.especialidad = datosRegistroMedico.especialidad();
        this.direccion = new Direccion(datosRegistroMedico.direccion());
    }

    public void actualizarDatos(DatosActualizarMedico datosActualizarMedico) {
        if (datosActualizarMedico.nombre() != null) {
            this.nombre = datosActualizarMedico.nombre();
        }
        if (datosActualizarMedico.documento() != null) {
            this.documento = datosActualizarMedico.documento();
        }
        if (datosActualizarMedico.direccion() != null) {
            this.direccion = direccion.actualizarDatos(datosActualizarMedico.direccion());
        }
    }

    public void desactivarMedico() {
        this.activo = false;
    }
}
