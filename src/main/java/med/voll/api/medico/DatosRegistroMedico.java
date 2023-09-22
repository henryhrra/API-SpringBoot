package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.direccion.DatosDireccion;

//Los @ son para las validaciones, indican que tipo de dato debe ser
public record DatosRegistroMedico(@NotBlank
                                  String nombre,
                                  @NotBlank
                                  @Email
                                  String email,

                                  @NotBlank
                                  String telefono,
                                  @NotBlank
                                  @Pattern(regexp = "\\d{4,6}")
                                  String documento,
                                  @NotNull
                                  Especialidad especialidad,
                                  @NotNull
                                  @Valid
                                  DatosDireccion direccion) {
 //Clase usada para metodo POST
    //atributos a recibir del fronted
    //@Notblank hace lo mismo que @NotNull es decir no puede ser Null o estar vacio
}