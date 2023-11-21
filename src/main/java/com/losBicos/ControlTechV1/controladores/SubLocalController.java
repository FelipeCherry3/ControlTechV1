package com.losBicos.ControlTechV1.controladores;


import com.losBicos.ControlTechV1.modelos.Ativos;
import com.losBicos.ControlTechV1.modelos.SubLocal;
import com.losBicos.ControlTechV1.repositories.SubLocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST}, allowedHeaders = "*")
@RequestMapping(path = "sublocal")
public class SubLocalController {

    @Autowired
    private SubLocalRepository sublocalRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<SubLocal> getAllSub(){
        return sublocalRepository.findAll();
    }

    @GetMapping(path = "/selecionar/{id}")
    public @ResponseBody SubLocal getAtivos(@PathVariable Long id){
        Optional<SubLocal> SubOp = sublocalRepository.findById(id);
        if(SubOp.isPresent()){
            return SubOp.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "SubLocal não encontrado");
        }
    }
    //Cadastro

    @PostMapping(path = "/cadastrar")
    public @ResponseBody String cadastrarLocal(@PathVariable SubLocal subLocal){
        sublocalRepository.save(subLocal);
        return "Sublocal Registrado com sucesso";
    }
    @PutMapping (path = "/atualiza/{id}")
    public @ResponseBody String atualizarSub(@PathVariable Long id,
                                             SubLocal novoSubLocal){
        Optional<SubLocal> subOP = sublocalRepository.findById(id);
        if (subOP.isPresent()){
            SubLocal subLocal = subOP.get();
            //Campos
            subLocal.setNomelocal(novoSubLocal.getNomelocal());
            subLocal.setDescricao(novoSubLocal.getDescricao());
            subLocal.setEndereco(novoSubLocal.getEndereco());

            //JPA Save
            sublocalRepository.save(subLocal);
            return "SubLocal Atualizado";
        }
        return "Erro ao atualizar";
    }
}

