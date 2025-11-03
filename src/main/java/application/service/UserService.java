package application.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public boolean validarCredenciais(String usuario, String senha) {
        return usuario.equals("admin") && senha.equals("1234");
    }
}
