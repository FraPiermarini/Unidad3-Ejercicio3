package com.programacion4.unidad3ej3.feature.producto.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;

import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {

    boolean existsByNombreIgnoreCase(String nombre);

    List<Producto> findByEstaEliminadoFalse(); 
    
}