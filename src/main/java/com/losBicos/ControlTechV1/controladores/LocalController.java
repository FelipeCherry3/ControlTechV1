package com.losBicos.ControlTechV1.controladores;

import com.losBicos.ControlTechV1.modelos.LocalArmazenado;
import com.losBicos.ControlTechV1.modelos.LocalSubLocal;
import com.losBicos.ControlTechV1.modelos.SubLocal;
import com.losBicos.ControlTechV1.repositories.LocalRepository;
import com.losBicos.ControlTechV1.repositories.SubLocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST}, allowedHeaders = "*")
@Controller
@RequestMapping(path = "local")
public class LocalController {

    @Autowired
    private LocalRepository localRepository;

    @Autowired
    private SubLocalRepository subLocalRepository;

    private static final Logger loogger = LoggerFactory.getLogger(LocalController.class);
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<LocalArmazenado> getAllLocal(){

        Iterable<LocalArmazenado> locais = localRepository.findAll();
        System.out.println("Locais recuperados: " + locais);
        return locais;
    }


    @GetMapping(path = "/selecionar/{id}")
    public @ResponseBody LocalArmazenado localGet (@PathVariable Long id){
        Optional<LocalArmazenado> localOP = localRepository.findById(id);
        if(localOP.isPresent()){
            return localOP.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Local nao encontrado'");

        }
    }
    @PostMapping(path = "/cadastrar")
    public @ResponseBody String cadastroTeste(@RequestBody LocalSubLocal localSubLocal){

        LocalArmazenado local = localSubLocal.getLocal();
        SubLocal sub = localSubLocal.getSublocal();
        local.setSubLocal(sub);
        localRepository.save(local);
        return "Local Armazenado";
    }

}
