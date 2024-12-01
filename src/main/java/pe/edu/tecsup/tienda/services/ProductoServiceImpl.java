package pe.edu.tecsup.tienda.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.tienda.entities.Producto;
import pe.edu.tecsup.tienda.repositories.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductoServiceImpl implements  ProductoService{

    ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> findAll() throws Exception {
        log.info("call findAll()");
        return this.productoRepository.findAll();
    }

    @Override
    public List<Producto> findByName(String nombre) throws Exception {
        log.info("call findByName()");
        return this.productoRepository.findByNombre(nombre);

    }

    @Override
    public Producto findById(Long id) throws Exception {
        log.info("call findById()");

        this.productoRepository.findById(id);

        Optional<Producto> byId = this.productoRepository.findById(id);

        if(byId.isPresent())
            return byId.get();
        else
            throw  new Exception("Errot to get data");
    }

    @Override
    public void save(Producto producto) throws Exception {
        log.info("call save()");
        this.productoRepository.save(producto);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        log.info("call deleteById()");
        this.productoRepository.deleteById(id);
    }

    @Override
    public void update(Producto producto) throws Exception {
        log.info("call update()");
        this.productoRepository.save(producto);
    }
}
