package com.losBicos.ControlTechV1.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "localarmazenado")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class LocalArmazenado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomelocal;
    private String endereco;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "sublocal")
    private SubLocal subLocal;

}
