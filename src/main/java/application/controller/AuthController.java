package application.controller;

import application.security.JwtUtil;
import application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired private UserService userService;
    @Autowired private JwtUtil jwtUtil;

    @PostMapping
    public Map<String, String> autenticar(@RequestBody Map<String, String> credenciais) {
        String usuario = credenciais.get("nomeDeUsuario");
        String senha = credenciais.get("senha");

        if (userService.validarCredenciais(usuario, senha)) {
            String token = jwtUtil.gerarToken(usuario);
            return Map.of("token", token);
        } else {
            throw new RuntimeException("Credenciais inválidas");
        }
    }
}
