package com.losBicos.ControlTechV1.Services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.losBicos.ControlTechV1.dto.DashboardDTO;
import com.losBicos.ControlTechV1.modelos.Software;
import com.losBicos.ControlTechV1.repositories.AtivoRepository;
import com.losBicos.ControlTechV1.repositories.SoftwareRepository;

@Service
public class DashboardService {
    
    @Autowired
    private AtivoRepository ativoRepository;

    @Autowired
    private SoftwareRepository softwareRepository;

    public DashboardDTO getIndicadores(){
        DashboardDTO dto = new DashboardDTO();

        dto.setTotalAtivos(ativoRepository.countTotalAtivos());

        // Total de Valor de Ativos
        dto.setTotalValor(ativoRepository.sumTotalValor());

        // Total de Licenças de Software
        dto.setTotalLicencas(softwareRepository.countTotalSoftware());

        // Softwares que vão expirar em menos de 2 meses
        LocalDate dataLimite = LocalDate.now().plusMonths(2);
        List<Software> expirando = softwareRepository.findExpirandoEmMenosDe(dataLimite);
        dto.setLicencasExpirando(expirando);

        return dto;
    } 
}
