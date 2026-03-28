package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoGetAllService;

@Service
public class ProductoGetAllService implements IProductoGetAllService {

    private final IProductoRepository repository;

    public ProductoGetAllService(IProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductoResponseDto> getAll() {
        return repository.findAll()
                .stream()
                .map(ProductoMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}