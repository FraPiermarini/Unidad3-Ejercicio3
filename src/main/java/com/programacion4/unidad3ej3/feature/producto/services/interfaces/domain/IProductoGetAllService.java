package com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain;

import java.util.List;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
public interface IProductoGetAllService {
    List<ProductoResponseDto> getAll();
}