package com.example.sistemafacturacion.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "client_name")
    @NotNull
    @Size(min = 2, max =10)
    private String clientName;

    @Column(name = "client_last_name")
    @NotNull
    @Size(min = 2, max =20)
    private String clientLastName;

    @Column(name = "client_dni")
    @NotNull
    @Size(min = 8, max =10)
    private String clientDni;

    @Column(name = "client_direction")
    @NotNull
    @Size(min = 5, max =10)
    private String clientDirection;

}
