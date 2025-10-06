package com.example.demo;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/messages")
public class MessageResource {

    @GetMapping("/simpleMessageWelcome")
    public String simpleMessageWelcome() {
        return "BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!";
    }

    @GetMapping("/login?user={user}&password={password}")
    public String login(@RequestParam("user") String user, @RequestParam("password") String password) {
        if (user.isEmpty() || password.isEmpty()) {
            return "USUÁRIO E SENHA NÃO INFORMADOS";
        } else if (user.length() > 15 || password.length() > 15) {
            return "USUÁRIO E SENHA INVÁLIDOS";
        }
        return "LOGIN EFETUADO COM SUCESSO !!!";
    }
}
