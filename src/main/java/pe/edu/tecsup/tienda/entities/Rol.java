package pe.edu.tecsup.tienda.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
@Entity
@Table(name = "roles")
public class Rol implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nombre;

    // Spring Security
    @Override
    public String getAuthority() {
        return this.nombre;
    }

}
