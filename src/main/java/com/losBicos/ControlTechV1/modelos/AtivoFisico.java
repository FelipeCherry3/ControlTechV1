package com.losBicos.ControlTechV1.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AtivoFisico extends Ativos{
    @ManyToOne
    private Usuario user;
}
