package com.losBicos.ControlTechV1.controladores;


import com.losBicos.ControlTechV1.modelos.Ativos;
import com.losBicos.ControlTechV1.repositories.AtivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin
@RequestMapping(path = "ativos")
public class AtivosControler {

    @Autowired
    private AtivoRepository ativoRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Ativos> getAllAtivos(){

        return ativoRepository.findAll();
    }

    //Cadastramento de Ativos

    @PostMapping(path = "/cadastrar")
    public @ResponseBody String cadastroAtivos(@RequestBody Ativos ativos){
            ativoRepository.save(ativos);
        return "Cadastrado com sucesso";
    }

    @PutMapping(path = "/atualiza{id}")
    public @ResponseBody String atualizarAtivo(@RequestBody Long id,
                                               Ativos novoAtivos){
        Optional<Ativos> ativoOp = ativoRepository.findById(id);

        if(ativoOp.isPresent()){
            Ativos ativo = ativoOp.get();

            //Campos para Atualização
            ativo.setStatusAtivo(novoAtivos.getStatusAtivo());
            ativo.setDescricao(novoAtivos.getDescricao());
            ativo.setNome(novoAtivos.getNome());
            ativo.setData_aquisicao(novoAtivos.getData_aquisicao());
            ativo.setQntEstoque(novoAtivos.getQntEstoque());
            ativo.setValorItem(novoAtivos.getValorItem());

            //Salvar JPA
            ativoRepository.save(ativo);

            return "Ativo Atualizado com sucesso";
        }
        return "Ativo não encontrado";
    }
}
