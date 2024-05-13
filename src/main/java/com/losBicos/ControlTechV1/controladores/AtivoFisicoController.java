package com.losBicos.ControlTechV1.controladores;

import com.losBicos.ControlTechV1.modelos.*;
import com.losBicos.ControlTechV1.repositories.AtivoFisicoRepository;
import com.losBicos.ControlTechV1.repositories.AtivoRepository;
import com.losBicos.ControlTechV1.repositories.LocalRepository;
import com.losBicos.ControlTechV1.repositories.UsersRepository;
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

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping(path = "/cadastrarTeste")
    public @ResponseBody String cadastroTeste(@RequestBody AtivoMiddleWare ativoMiddleWare){
        Ativos ativo = ativoMiddleWare.getAtivos();
        Optional<LocalArmazenado> local = localRepository.findById(Long.valueOf(ativoMiddleWare.getAtivos().getIdLocalArmazenado()));
        if (local.isPresent()){
            ativo.setLocalArmazenado(local.get());
        }
        Ativos ativoCad = ativoRepository.save(ativo);

        // Verificando se o Ativos foi salvo corretamente
        if (ativoCad != null) {
            AtivoFisico ativoFisico = ativoMiddleWare.getAtivoFisico();
            // Associando o Ativos recém-cadastrado ao AtivoFisico
            ativoFisico.setProduto(ativoCad);
            Usuario user = usersRepository.getById(Long.valueOf(ativoMiddleWare.getUsuario().getId_user()));
            ativoFisico.setUser(user);
            // Salvando o AtivoFisico
            ativoFisicoRepository.save(ativoFisico);

            return "Cadastro Realizado com sucesso";
        } else {
            return "Erro ao cadastrar Ativos";
        }
    }
}
