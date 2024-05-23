package com.losBicos.ControlTechV1.controladores;

import com.losBicos.ControlTechV1.modelos.Licencas;
import com.losBicos.ControlTechV1.repositories.LicencasRepository;
import com.losBicos.ControlTechV1.repositories.SoftwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping(path="licenca")
public class LicencaController {

    @Autowired
    private LicencasRepository licencasRepository;

    @Autowired
    private SoftwareRepository softwareRepository;

    @PostMapping(path = "/cadastrar")
    public @ResponseBody String cadastrarLicenca(@RequestBody Licencas licenca){
        licencasRepository.save(licenca);
        return "Sucesso ao cadastrar";

    }

}
