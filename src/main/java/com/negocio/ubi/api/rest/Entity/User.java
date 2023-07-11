package com.negocio.ubi.api.rest.Entity;

import com.negocio.ubi.api.rest.Enum.TipoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="usuarios")
@Entity(name="usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    @Column(name="nombre")
    @NotNull
    @Size(min=1, max=50, message="no cumple con la longitud")
    private String nombre;

    @Column(name="mail")
    @NotNull
    @Size(max=100)
    private String mail;

    @Column(name="tipo_usuario")
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private TipoUsuario tipoUsuario;

    public User(String nombre, String mail, TipoUsuario tipoUsuario) {
        this.nombre = nombre;
        this.mail = mail;
        this.tipoUsuario = tipoUsuario;
    }


}
