package com.programacion4.unidad3ej3.feature.producto.dtos.request;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoUpdateRequestDto {

    @NotBlank
    private String nombre;

    @NotBlank
    private String codigo;

    @NotBlank
    private String descripcion;

    @NotNull
    private Double precio;

    @NotNull
    private Integer stock;
}