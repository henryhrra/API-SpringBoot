package med.voll.api.medico;

public record DatosListadoMedico(Long id, String nombre, String especialidad, String documento, String email) {
//Clase usada para mostrar solo los datos necesarios
    public DatosListadoMedico(Medico medico) {
        this(medico.getId(), medico.getNombre(), medico.getEspecialidad().toString(), medico.getDocumento(), medico.getEmail());
    }
}


