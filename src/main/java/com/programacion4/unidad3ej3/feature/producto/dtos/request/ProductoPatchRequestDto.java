package com.programacion4.unidad3ej3.feature.producto.dtos.request;

import lombok.Data;

@Data
public class ProductoPatchRequestDto {

    private Double precio;
    private Integer stock;
}

