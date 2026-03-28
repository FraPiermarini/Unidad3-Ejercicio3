package com.programacion4.unidad3ej3.feature.producto.controllers.post;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoGetAllService;

@RestController
public class ProductoGetAllController {

    private final IProductoGetAllService service;

    public ProductoGetAllController(IProductoGetAllService service) {
        this.service = service;
    }

    @GetMapping("/productos")
    public List<ProductoResponseDto> getAll() {
        return service.getAll();
    }
}