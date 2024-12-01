package pe.edu.tecsup.tienda.services;

import pe.edu.tecsup.tienda.entities.Categoria;

import java.util.List;

public interface CategoriaService {

    List<Categoria> findAll() throws Exception;

}
