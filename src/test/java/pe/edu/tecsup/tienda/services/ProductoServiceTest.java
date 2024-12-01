package pe.edu.tecsup.tienda.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.entities.Producto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
class ProductoServiceTest {

    @Autowired
    ProductoService productoService;

    @Test
    void findAll() throws Exception {
        Boolean VALUE_EXPECTED = true;

        log.info("Start testing ");

        List<Producto> productos = this.productoService.findAll();
        productos.stream().forEach(prod -> log.info(prod.getNombre()));
        productos.isEmpty();

        assertEquals(VALUE_EXPECTED, !productos.isEmpty());

    }

    @Test
    void findByName() throws Exception {

        Boolean VALUE_EXPECTED = true;

        List<Producto> productos = this.productoService.findByName("Kingstone");

        log.info("Print by productos" + productos.size());
        productos.stream().forEach(prod -> log.info(prod.getNombre()));

        assertEquals(VALUE_EXPECTED, !productos.isEmpty());
    }

    @Test
    void findById() throws Exception {

        String NAME_EXPECTED = "Kingstone";
        Long ID = 2L;
        Producto producto = this.productoService.findById(ID);
        log.info(producto.toString());

        assertEquals(NAME_EXPECTED, producto.getNombre());

    }

    @Test
    void save() throws Exception {

        List<Producto> productos = this.productoService.findAll();
        int totalAntes = productos.size();

        Producto producto = new Producto();

        Categoria categoria = new Categoria();
        categoria.setId(1L);
        producto.setCategoria(categoria);

        producto.setNombre("AMD");
        producto.setDescripcion("AMD X10");
        producto.setPrecio(280.0);
        producto.setStock(6);
        producto.setEstado(1);

        this.productoService.save(producto);

        productos = this.productoService.findAll();
        int totalDespues = productos.size();

        assertEquals(1, totalDespues - totalAntes);
    }

    @Test
    void deleteById() throws Exception {
        List<Producto> productos = this.productoService.findAll();
        int totalAntes = productos.size();
        if (productos.isEmpty()) {
            return; // test pass
        }

        Producto ultimoProducto = productos.get(productos.size() - 1);
        this.productoService.deleteById(ultimoProducto.getId());

        productos = this.productoService.findAll();
        int totalDespues = productos.size();

        assertEquals(1, totalAntes - totalDespues);
    }

    @Test
    void update() throws Exception {

        // Actualizar el nombre del producto
        Long id = 1L; // Relacionado con tus datos de pruebas
        String NOMBRE_ORIGINAL = "Procesador Intel";
        String NOMBRE_A_CAMBIAR = "Procesador Intel Cambiado";
        Producto prod = null;


        // Actualizar nombre original
        prod = productoService.findById(id);
        prod.setNombre(NOMBRE_ORIGINAL);
        productoService.update(prod);


        // Verificar que el nombre ha sido cambiado
        prod = productoService.findById(id);
        assertEquals(NOMBRE_ORIGINAL, prod.getNombre());


        // Actualizar nombre a cambiar
        prod = productoService.findById(id);
        prod.setNombre(NOMBRE_A_CAMBIAR);
        productoService.update(prod);


        // Verificar que el nombre ha sido cambiado
        prod = productoService.findById(id);
        assertEquals(NOMBRE_A_CAMBIAR, prod.getNombre());
    }
}