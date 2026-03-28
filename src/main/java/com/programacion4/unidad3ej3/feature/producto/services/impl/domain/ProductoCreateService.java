package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;
import org.springframework.stereotype.Service;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoCreateService;
import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoCreateRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.commons.IProductoExistByNameService;
import com.programacion4.unidad3ej3.config.exceptions.ConflictException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoCreateService implements IProductoCreateService {

    private final IProductoExistByNameService productoExistByNameService;
    private final IProductoRepository productoRepository;
    private String capitalize(String texto) {
    if (texto == null || texto.isEmpty()) return texto;

    texto = texto.toLowerCase();

    return texto.substring(0, 1).toUpperCase() + texto.substring(1);
}

    @Override
    public ProductoResponseDto create(ProductoCreateRequestDto dto) {
        String nombreNormalizado = capitalize(dto.getNombre());
        String descripcionNormalizada = capitalize(dto.getDescripcion());
        if (productoExistByNameService.existsByNombre(dto.getNombre())) {
            throw new ConflictException("El nombre del producto ya existe");
        }
        dto.setNombre(nombreNormalizado);
        dto.setDescripcion(descripcionNormalizada);
        dto.setNombre(capitalize(dto.getNombre()));
        dto.setDescripcion(capitalize(dto.getDescripcion()));
        Producto productoAGuardar = ProductoMapper.toEntity(dto);

        Producto productoGuardado = productoRepository.save(productoAGuardar);

        return ProductoMapper.toResponseDto(productoGuardado);
    }
}