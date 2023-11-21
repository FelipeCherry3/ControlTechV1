package com.losBicos.ControlTechV1.controladores;

import com.losBicos.ControlTechV1.modelos.LocalArmazenado;
import com.losBicos.ControlTechV1.repositories.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST}, allowedHeaders = "*")
@Controller
@RequestMapping(path = "local")
public class LocalController {

    @Autowired
    private LocalRepository localRepository;

    private static final Logger loogger = LoggerFactory.getLogger(LocalController.class);
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<LocalArmazenado> getAllLocal(){

        Iterable<LocalArmazenado> locais = localRepository.findAll();
        System.out.println("Locais recuperados: " + locais);
        return locais;
    }

    @PostMapping(path = "cadastrar")
    public @ResponseBody String cadastroLocal(@RequestBody LocalArmazenado local){
        System.out.println("Objeto Local recebido: " + local.getNomelocal() + " " + local.getEndereco() + " " + local.getDescricao() + " ");
        try {

            localRepository.save(local);
            loogger.info("Local cadastrado com sucesso: {}", local);
            return "Cadastro Concluído";
        } catch (Exception e) {
            loogger.error("Erro ao cadastrar local", e);
            return "Erro ao cadastrar local";
        }
    }

}
