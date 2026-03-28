package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;
import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.config.exceptions.ResourceNotFoundException;
import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoPatchRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoPatchService;

@Service
public class ProductoPatchService implements IProductoPatchService {

    private final IProductoRepository repository;

    public ProductoPatchService(IProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductoResponseDto patch(Long id, ProductoPatchRequestDto dto) {

        Producto producto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        
        if (dto.getPrecio() != null) {
            producto.setPrecio(dto.getPrecio());
        }

        if (dto.getStock() != null) {
            producto.setStock(dto.getStock());
        }

        Producto actualizado = repository.save(producto);

        return ProductoMapper.toResponseDto(actualizado);
    }
}