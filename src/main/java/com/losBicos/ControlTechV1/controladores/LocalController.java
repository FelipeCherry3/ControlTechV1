package com.losBicos.ControlTechV1.controladores;

import com.losBicos.ControlTechV1.modelos.LocalArmazenado;
import com.losBicos.ControlTechV1.repositories.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping(path = "local")
public class LocalController {

    @Autowired
    private LocalRepository localRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<LocalArmazenado> getAllLocal(){

        Iterable<LocalArmazenado> locais = localRepository.findAll();
        System.out.println("Locais recuperados: " + locais);
        return locais;
    }

    @PostMapping(path = "cadastrar")
    public @ResponseBody String cadastroLocal(@RequestBody LocalArmazenado local){
        localRepository.save(local);
        return "Cadastro Concluido";
    }
}
