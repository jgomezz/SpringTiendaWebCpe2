package pe.edu.tecsup.tienda.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.tecsup.tienda.entities.Categoria;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Slf4j
@SpringBootTest
class CategoriaServiceTest {

    @Autowired
    CategoriaService categoriaService;

    @Test
    void findAll() throws Exception {

        Boolean VALUE_EXPECTED = true;

        log.info("Start testing ");

        List<Categoria> categorias =  this.categoriaService.findAll();
        categorias.stream().forEach(cat -> System.out.println(cat.getNombre()));
        categorias.isEmpty();

        assertEquals(VALUE_EXPECTED, !categorias.isEmpty());

    }
}