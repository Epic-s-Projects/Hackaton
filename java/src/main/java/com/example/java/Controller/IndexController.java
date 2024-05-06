package com.example.java.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/home")
    public String acessoHomePage() {
        return "index";
    }
    @GetMapping("/login")
    public String acessoLogin() {
        return "cadastro/cadastro_login";
    }
}
