package com.programacion4.unidad3ej3.feature.producto.controllers.patch;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoPatchRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoPatchService;

@RestController
public class ProductoPatchController {

    private final IProductoPatchService service;

    public ProductoPatchController(IProductoPatchService service) {
        this.service = service;
    }

    @PatchMapping("/productos/{id}")
    public ProductoResponseDto patch(
            @PathVariable Long id,
            @RequestBody ProductoPatchRequestDto dto) {

        return service.patch(id, dto);
    }
}
