package com.losBicos.ControlTechV1.controladores;

import com.losBicos.ControlTechV1.modelos.Categoria;
import com.losBicos.ControlTechV1.repositories.CategoriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST}, allowedHeaders = "*")
@Controller
@RequestMapping(path = "categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    private static final Logger logger = LoggerFactory.getLogger(CategoriaController.class);

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Categoria> getCategorias(){
        Iterable<Categoria> categorias = categoriaRepository.findAll();
        System.out.println("Categorias " + categorias);
        return categorias;
    }

    @GetMapping(path = "selecionar/{id}")
    public @ResponseBody Categoria categoriaGet(@PathVariable Long id){
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        if(categoriaOptional.isPresent()){
            return categoriaOptional.get();
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Não encontrado");
        }
    }
    @PostMapping(path = "cadastrar")
    public @ResponseBody String cadadstro(@RequestBody Categoria categoria){
        categoriaRepository.save(categoria);
        return "SAlvo com sucesso";
    }
}
