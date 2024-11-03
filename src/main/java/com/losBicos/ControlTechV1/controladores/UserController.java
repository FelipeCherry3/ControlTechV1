package com.losBicos.ControlTechV1.controladores;

import com.losBicos.ControlTechV1.repositories.UsersRepository;

import jakarta.persistence.NonUniqueResultException;

import com.losBicos.ControlTechV1.modelos.Usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping(path = "users")
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping(path= "/all")
    public @ResponseBody Iterable<Usuario> getAllUsers() {
        return usersRepository.findAll();
    }

    // Rota para cadastrar um novo usuário
    @PostMapping(path = "/cadastro")
    public @ResponseBody String cadastrarUsuario(@RequestBody Usuario usuario) {
        usersRepository.save(usuario);

       return "Usuário cadastrado com sucesso!";
    }
    //Retorna usuario por username(login)

    // Rota para fazer login
    @PostMapping(path = "/login")
    public @ResponseBody String fazerLogin(@RequestParam String nome, @RequestParam String user_password) {
        List<Usuario> usuarios = usersRepository.findByLogin(nome);
        if (usuarios != null && usuarios.get(0).getUser_password().equals(user_password)){
            //Implementar login XXX Erro de lógica
            return "Login bem-sucedido!";

        } else if (usuarios == null) {
            return "Usuário não encontrado!";
        } else {
            return "Senha incorreta!";
        }
    }

    @GetMapping(path = "/findbylogin")
    public @ResponseBody Usuario findByLogin(@RequestParam String login) {
        List<Usuario> usuarios = usersRepository.findByLogin(login);
        if (usuarios.size() == 1) {
            return usuarios.get(0);
        } else {
            return usuarios.get(0);
        }
    }
}
