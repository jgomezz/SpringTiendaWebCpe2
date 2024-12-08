package pe.edu.tecsup.tienda.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import java.util.ArrayList;
import java.util.List;

/*
class RawPasswordEncoder implements PasswordEncoder {

   @Override
   public String encode(CharSequence rawPassword) {
       return rawPassword.toString();
   }

   @Override
   public boolean matches(CharSequence rawPassword, String encodedPassword) {
       return rawPassword.toString().equals(encodedPassword);
   }
}
//*/

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        //return new RawPasswordEncoder();    // Algoritmo Raw
        return new BCryptPasswordEncoder();    // Algoritmo BCrypt
    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth)
            throws Exception{
        auth.userDetailsService(userDetailsService);
    }


    /*
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {

        List<UserDetails> users = new ArrayList<>();

        users.add(User.withUsername("user")
                .password(passwordEncoder().encode("user"))
                .roles("USER").build());
        users.add(User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("USER","ADMIN").build());

        return new InMemoryUserDetailsManager(users);
    }
    */




}
