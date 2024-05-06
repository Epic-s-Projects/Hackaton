package com.example.java.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.java.Model.Usuario;
import com.example.java.Repository.UsuarioRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsuarioController {
    @Autowired
    UsuarioRepository ur;

    @Autowired
    private HttpSession httpSession;

    boolean acessoUsuario = false;

    @PostMapping("/cadastrar-usuario")
    public String cadastrarAlunoBD(Usuario usuario, Model model) {
        try {
            ur.save(usuario);
            System.out.println("Cadastro realizado com sucesso!");
            return "/cadastro/cadastro_login";
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar usuario: " + e.getMessage());
            model.addAttribute("erroSenha", "Sua senha está incorreta");
            return "/cadastro/cadastro_login";
        }
    }

    @PostMapping("acesso-usuario")
public String acessoAluno(@RequestParam String email, @RequestParam String senha, Model model) {
    try {
        boolean verificaEmail = ur.existsByEmail(email) != null;
        boolean verificaSenha = verificaEmail && ur.findByEmail(email).getSenha().equals(senha);
        String url = "";
        if (verificaSenha) {
            Usuario usuario = ur.findByEmail(email);
            httpSession.setAttribute("usuario", usuario);
            httpSession.setAttribute("loggedin", true);
            model.addAttribute("logado", true); // Definindo a variável de modelo "logado" como true
            url = "redirect:/home";
        } else {
            model.addAttribute("logado", false); // Definindo a variável de modelo "logado" como false
            url = "redirect:/login";
        }
        return url;
    } catch (Exception e) {
        return "redirect:/login";
    }
}


    // @PostMapping("acesso-usuario")
    // public String acessoAluno(@RequestParam String ra, @RequestParam String senha) {
    //     // método para verificar acesso
    //     try {
    //         boolean verificaRa = alr.existsById(ra);
    //         boolean verificaSenha = alr.findByRa(ra).getSenha().equals(senha);
    //         String url = "";
    //         if (verificaRa && verificaSenha) {
    //             Aluno aluno = alr.findByRa(ra);
    //             httpSession.setAttribute("aluno", aluno);
    //             httpSession.setAttribute("loggedin", true);
    //             acessoAluno = true;
    //             url = "redirect:/interna-aluno";
    //         } else {
    //             url = "redirect:/login-aluno";
    //         }
    //         return url;
    //     } catch (Exception e) {
    //         return "redirect:/login-aluno";
    //     }
    // }
}
