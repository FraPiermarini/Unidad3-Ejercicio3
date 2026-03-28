package com.programacion4.unidad3ej3.feature.producto.controllers.delete;
import com.programacion4.unidad3ej3.feature.producto.services.impl.domain.ProductoDeleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoDeleteController {

    private final ProductoDeleteService service;

    public ProductoDeleteController(ProductoDeleteService service) {
        this.service = service;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build(); 
    }
}