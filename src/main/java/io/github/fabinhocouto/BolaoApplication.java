package io.github.fabinhocouto;

import io.github.fabinhocouto.domain.entity.Usuario;
import io.github.fabinhocouto.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BolaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BolaoApplication.class, args);
    }
}
