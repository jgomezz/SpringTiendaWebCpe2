package pe.edu.tecsup.tienda.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.tienda.repositories.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService    {

    private UsuarioRepository usuarioRepository;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UserDetails userDetails
                = usuarioRepository.loadUserByUsername(username);

        if(userDetails == null)
            throw new UsernameNotFoundException("Usuario no encontrado");

        return userDetails;

    }

}
