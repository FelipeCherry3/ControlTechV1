package com.losBicos.ControlTechV1.controladores;

import com.losBicos.ControlTechV1.repositories.UsersRepository;
import com.losBicos.ControlTechV1.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping(path="/users")
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
    // Rota para fazer login
    @PostMapping(path = "/login")
    public @ResponseBody String fazerLogin(@RequestParam String nome, @RequestParam String user_password) {
        Usuario usuario = usersRepository.findByNome(nome);
        if (usuario != null && usuario.getUser_password().equals(user_password)){
            //Implementar login
            return "Login bem-sucedido!";

        } else if (usuario == null) {

        }
        return "Login bem-sucedido!";
    }
}
