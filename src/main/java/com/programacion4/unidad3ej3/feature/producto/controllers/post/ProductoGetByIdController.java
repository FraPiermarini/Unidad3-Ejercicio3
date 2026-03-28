package com.programacion4.unidad3ej3.feature.producto.controllers.post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoGetByIdService;

@RestController
public class ProductoGetByIdController {

    private final IProductoGetByIdService service;

    public ProductoGetByIdController(IProductoGetByIdService service) {
        this.service = service;
    }

    @GetMapping("/productos/{id}")
    public ProductoResponseDto getById(@PathVariable Long id) {
        return service.getById(id);
    }
}