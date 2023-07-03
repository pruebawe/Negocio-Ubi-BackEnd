package com.negocio.ubi.api.rest.Dto;

import com.negocio.ubi.api.rest.Enum.TipoUsuario;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoUser {

    @NotBlank
    private String nombre;
    @NotBlank
    private String mail;
    @NotBlank
    private TipoUsuario tipoUsuario;
}
