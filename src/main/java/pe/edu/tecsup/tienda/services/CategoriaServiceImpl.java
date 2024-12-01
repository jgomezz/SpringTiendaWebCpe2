package pe.edu.tecsup.tienda.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.repositories.CategoriaRepository;

import java.util.List;

@Slf4j
@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() throws Exception {
        log.info("Cqll findAll() ");
        return categoriaRepository.findAll();
    }


}
