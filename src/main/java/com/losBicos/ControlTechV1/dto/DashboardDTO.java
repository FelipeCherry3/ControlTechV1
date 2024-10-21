package com.losBicos.ControlTechV1.dto;

import java.util.List;

import com.losBicos.ControlTechV1.modelos.Software;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DashboardDTO {
    private Long totalAtivos;
    private Double totalValor;
    private Long totalLicencas;
    private List<Software> licencasExpirando;
}
