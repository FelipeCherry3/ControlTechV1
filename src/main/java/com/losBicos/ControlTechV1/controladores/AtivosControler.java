package com.losBicos.ControlTechV1.controladores;


import com.losBicos.ControlTechV1.modelos.Ativos;
import com.losBicos.ControlTechV1.modelos.LocalArmazenado;
import com.losBicos.ControlTechV1.modelos.Software;
import com.losBicos.ControlTechV1.repositories.AtivoRepository;
import com.losBicos.ControlTechV1.repositories.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
@CrossOrigin
@RequestMapping(path = "ativos")
public class AtivosControler {

    @Autowired
    private AtivoRepository ativoRepository;

    @Autowired
    private LocalRepository localRepository;
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Ativos> getAllAtivos(){

        return ativoRepository.findAll();
    }

    @GetMapping(path = "/selecionarPorLocal")
    public @ResponseBody Iterable<Ativos> getAllAtivosByLocal(@PathVariable LocalArmazenado local){

        Iterable<Ativos> byLocalArmazenado = (Iterable<Ativos>) ativoRepository.findByLocalArmazenado(local);

        return byLocalArmazenado;
    }

    //Cadastramento de Ativos

    @PostMapping(path = "/cadastrar")
    public @ResponseBody String cadastroAtivos(@RequestBody Ativos ativos){
        Optional<LocalArmazenado> local = localRepository.findById(Long.valueOf(ativos.getIdLocalArmazenado()));
        if(local.isPresent()){
            LocalArmazenado localArmazenado = local.get();
            ativos.setLocalArmazenado(localArmazenado);
        }
            ativoRepository.save(ativos);
        return "Cadastrado com sucesso";
    }

    @GetMapping(path = "/selecionar{id}")
    public @ResponseBody Ativos getAtivos(@PathVariable Long id){
        Optional<Ativos> ativoOp = ativoRepository.findById(id);
        if(ativoOp.isPresent()){
            return ativoOp.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ativo não encontrado");
        }
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
