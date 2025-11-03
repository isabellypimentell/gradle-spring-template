package application.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    // Injeção via construtor (recomendada)
    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Desabilita CSRF (útil para APIs REST)
            .csrf(AbstractHttpConfigurer::disable)

            // Configura regras de autorização
            .authorizeHttpRequests(auth -> auth
                // Endpoints públicos
                .requestMatchers("/auth/**", "/login", "/register", "/public/**").permitAll()
                // Todos os outros endpoints exigem autenticação
                .anyRequest().authenticated()
            )

            // Adiciona o filtro JWT antes do filtro padrão de autenticação do Spring Security
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
