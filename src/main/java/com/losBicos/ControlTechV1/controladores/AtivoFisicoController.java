package com.losBicos.ControlTechV1.controladores;

import com.losBicos.ControlTechV1.modelos.*;
import com.losBicos.ControlTechV1.repositories.AtivoFisicoRepository;
import com.losBicos.ControlTechV1.repositories.AtivoRepository;
import com.losBicos.ControlTechV1.repositories.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin
@RequestMapping(path = "ativofisico")
public class AtivoFisicoController {
    @Autowired
    private AtivoRepository ativoRepository;
    @Autowired
    private AtivoFisicoRepository ativoFisicoRepository;
    @Autowired
    private LocalRepository localRepository;

    @PostMapping(path = "/cadastrarTeste")
    public @ResponseBody String cadastroTeste(@RequestBody AtivoMiddleWare ativoMiddleWare){
        Ativos ativo = ativoMiddleWare.getAtivos();
        Optional<LocalArmazenado> local = localRepository.findById(Long.valueOf(ativoMiddleWare.getLocal().getId()));
        if (local.isPresent()){
            ativo.setLocalArmazenado(local.get());
        }
        ativoRepository.save(ativo);
        Ativos ativoCad = ativoRepository.findByNome(ativo.getNome());
        AtivoFisico ativoFisico = ativoMiddleWare.getAtivoFisico();
        ativoFisico.setProduto(ativoCad);

        ativoFisicoRepository.save(ativoFisico);

        return "Cadastro Realizado com sucesso";
    }
}
