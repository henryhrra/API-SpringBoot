package med.voll.api.direccion;

import jakarta.validation.constraints.NotBlank;

public record DatosDireccion(
        //Segundo DTO para el metodo GET
        //Al igual que en DatosRegistroMedico el uso de los @
        @NotBlank
        String calle,
        @NotBlank
        String distrito,
        @NotBlank
        String ciudad,
        @NotBlank
        String numero,
        @NotBlank
        String complemento) {

}
