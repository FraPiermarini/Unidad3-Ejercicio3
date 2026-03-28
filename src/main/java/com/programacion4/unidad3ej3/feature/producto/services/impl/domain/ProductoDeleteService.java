package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.config.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProductoDeleteService {

    private final IProductoRepository repository;

    public ProductoDeleteService(IProductoRepository repository) {
        this.repository = repository;
    }

    public void delete(Long id) {

        Producto producto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        producto.setEstaEliminado(true); // 👈 CORREGIDO

        repository.save(producto);
    }
}