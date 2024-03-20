package com.losBicos.ControlTechV1.modelos;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor

public class Cards {
    private String nomeLocal;
    private String descricao;
    private int nDeAtivos;
    private List<SubLocal> sublocais;
    private Double totalValue;

}
