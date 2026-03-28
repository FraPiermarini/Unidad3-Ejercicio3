package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;
import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.config.exceptions.ResourceNotFoundException;
import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoUpdateRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoUpdateService;

@Service
public class ProductoUpdateService implements IProductoUpdateService {

    private final IProductoRepository repository;

    public ProductoUpdateService(IProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductoResponseDto update(Long id, ProductoUpdateRequestDto dto) {

        Producto producto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        producto.setNombre(dto.getNombre());
        producto.setCodigo(dto.getCodigo());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());

        Producto actualizado = repository.save(producto);

        return ProductoMapper.toResponseDto(actualizado);
    }
}