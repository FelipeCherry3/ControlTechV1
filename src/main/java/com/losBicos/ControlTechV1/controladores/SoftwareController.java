package com.losBicos.ControlTechV1.controladores;

import com.losBicos.ControlTechV1.modelos.Software;
import com.losBicos.ControlTechV1.repositories.SoftwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
@CrossOrigin
@RequestMapping(path="software")
public class SoftwareController {

    @Autowired
    private SoftwareRepository softwareRepository;

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

    @GetMapping(path = "/selecionar{id}")
    public @ResponseBody Software getSoftware(@PathVariable Long id){
        Optional<Software> software = softwareRepository.findById(id);
        if(software.isPresent()){
            Software realSoftware = software.get();
            return realSoftware;
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
}
