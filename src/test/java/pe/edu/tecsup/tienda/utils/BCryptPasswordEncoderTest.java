package pe.edu.tecsup.tienda.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@SpringBootTest
public class BCryptPasswordEncoderTest {


	@Test
    void testCreateBCryptPassword() {
		
        // Create an instance of BCryptPasswordEncoder
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Encode a password
        String rawPassword = "tecsup"; // Here
        String encodedPassword = passwordEncoder.encode(rawPassword);

        log.info("Raw Password: " + rawPassword);
        log.info("Encoded Password: " + encodedPassword);

        // Check if a provided password matches the encoded password
        String providedPassword = "tecsup"; // Here
        boolean passwordMatches = passwordEncoder.matches(providedPassword, encodedPassword);

        log.info("Password Matches: " + passwordMatches);
    }
}
// 2024-12-08T09:55:42.604-05:00  INFO 38725 --- [SpringTiendaWebCpe] [           main] p.e.t.t.utils.BCryptPasswordEncoderTest  : Encoded Password: $2a$10$UQCXBmav5dNlUrSWgxq.yewbO.hKZjpkB8fdfGUgTZqC34oEVcffi
// 2024-12-08T09:56:43.004-05:00  INFO 38998 --- [SpringTiendaWebCpe] [           main] p.e.t.t.utils.BCryptPasswordEncoderTest  : Encoded Password: $2a$10$FS0IH3pG8xoioYI6TRntGe0tTLZN3OKa2B4oRFMjgfB6QImdd2U9G