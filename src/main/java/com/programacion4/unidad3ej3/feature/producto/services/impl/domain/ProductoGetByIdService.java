package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;
import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoGetByIdService;
import com.programacion4.unidad3ej3.config.exceptions.ResourceNotFoundException;

@Service
public class ProductoGetByIdService implements IProductoGetByIdService {

    private final IProductoRepository repository;

    public ProductoGetByIdService(IProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductoResponseDto getById(Long id) {

        Producto producto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        return ProductoMapper.toResponseDto(producto);
    }
}