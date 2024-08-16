package com.devsuperior.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    /**  Registrando Componentes.
         Usamos o Configuration e o Bean quando queremos registrar uma classe na qual 
        não temos acesso de alteração, até porque já foram compiladas.
    */
    
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()); // desativando segurança de ataque csrf. API Rest não guarda dados em sessão
        http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll()); // Permitindo qualquer requisição.
        return http.build();
    }

    
}
