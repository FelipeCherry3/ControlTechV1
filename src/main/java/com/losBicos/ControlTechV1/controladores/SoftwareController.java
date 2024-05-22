package com.losBicos.ControlTechV1.controladores;

import com.losBicos.ControlTechV1.modelos.*;
import com.losBicos.ControlTechV1.repositories.AtivoRepository;
import com.losBicos.ControlTechV1.repositories.LocalRepository;
import com.losBicos.ControlTechV1.repositories.ProdutoCategoriaRepository;
import com.losBicos.ControlTechV1.repositories.SoftwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@CrossOrigin
@RequestMapping(path="software")
public class SoftwareController {

    @Autowired
    private SoftwareRepository softwareRepository;

    @Autowired
    private LocalRepository localRepository;

    @Autowired
    private AtivoRepository ativoRepository;
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Software> getAllSoftware(){
        return softwareRepository.findAll();
    }

    // Cadastro de Software
    @PostMapping(path = "/cadastrar")
    public @ResponseBody String cadastrarSoftware(@RequestBody Software software){
        softwareRepository.save(software);
        return "Software Cadastrado";
    }
    @PostMapping(path = "/cadastrarTeste")
    public @ResponseBody String cadastroTeste(@RequestBody AtivoMiddleWare ativoMiddleWare){
        Ativos ativo = ativoMiddleWare.getAtivos();
        Optional<LocalArmazenado> local = Optional.ofNullable(ativoMiddleWare.getLocal());
        if (local.isPresent()){
            ativo.setLocalArmazenado(local.get());
        }
        ativoRepository.save(ativo);
        Ativos ativoCad = ativoRepository.findByNome(ativo.getNome());
        Software software = ativoMiddleWare.getSoftware();
        software.setProduto(ativoCad);


        softwareRepository.save(software);

        return "Cadastro Realizado com sucesso";
    }


    @GetMapping(path = "/selecionar{id}")
    public @ResponseBody Software getSoftware(@PathVariable Long id){
        Optional<Software> software = softwareRepository.findById(id);
        if(software.isPresent()){
            return software.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Software nao encontrado'");
        }
    }

    @PutMapping(path = "/atualizar/{id}")
    public @ResponseBody String atualizarSoftware(@PathVariable Long id,
                                                  @RequestBody Software novoSoftware){
        Optional<Software> softwareOptional = softwareRepository.findById(id);

        if (softwareOptional.isPresent()) {
            Software softwareExistente = softwareOptional.get();
            // Atualize os campos necessários do -softwareExistente- com os valores do -novoSoftware-
            softwareExistente.getProduto().setNome(
                    novoSoftware.getProduto().getNome());

            softwareExistente.setVersao(novoSoftware.getVersao());
            softwareExistente.setData_expira(novoSoftware.getData_expira());
            softwareExistente.setN_licenca(novoSoftware.getN_licenca());
            softwareExistente.setTipo_OS(novoSoftware.getTipo_OS());


            // Salve o software atualizado no repositório
            softwareRepository.save(softwareExistente);

            return "Software Atualizado";
        } else {
            return "Software não encontrado";
        }
    }
    @DeleteMapping(path = "/deletar/{id}")
    public @ResponseBody String deleteSoftware(@PathVariable Long id){
        Optional<Software> softwareOptional = softwareRepository.findById(id);
        if(softwareOptional.isPresent()){
            Software softwareExiste = softwareOptional.get();
            //Excluir
            softwareRepository.delete(softwareExiste);
            return "Software Removido com sucesso";
        } else {
            return "Erro ao Excluir Software";
        }
    }
    @GetMapping(path = "/by-ativo-name/{name}")
    public @ResponseBody Software getSoftwareByAtivoName(@PathVariable("name") String ativoNome) {
        Ativos ativo = ativoRepository.findByNome(ativoNome);
            Optional<Software> software = softwareRepository.findByProduto(ativo);
            if (software.isPresent()) {
                return software.get();
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Software not found");
            }
    }

    @GetMapping(path = "/licencas/{id}")
    public @ResponseBody Iterable<Licencas> getLicencas(@PathVariable Long id_software){
        Optional<Software> optionalSoftware = softwareRepository.findById(id_software);
        if (optionalSoftware.isPresent()) {
            return optionalSoftware.get().getLicencas();
        } else {
            // Retorna uma lista vazia
            return new ArrayList<>();
        }
    }


}
