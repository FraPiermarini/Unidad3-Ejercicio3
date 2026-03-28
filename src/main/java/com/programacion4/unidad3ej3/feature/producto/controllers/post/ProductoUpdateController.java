package com.programacion4.unidad3ej3.feature.producto.controllers.post;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoUpdateRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoUpdateService;

@RestController
public class ProductoUpdateController {

    private final IProductoUpdateService service;

    public ProductoUpdateController(IProductoUpdateService service) {
        this.service = service;
    }

    @PutMapping("/productos/{id}")
    public ProductoResponseDto update(
            @PathVariable Long id,
            @Valid @RequestBody ProductoUpdateRequestDto dto) {

        return service.update(id, dto);
    }
}