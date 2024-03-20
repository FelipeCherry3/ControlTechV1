package com.losBicos.ControlTechV1.Services;

import com.losBicos.ControlTechV1.modelos.Ativos;
import com.losBicos.ControlTechV1.modelos.Cards;
import com.losBicos.ControlTechV1.modelos.LocalArmazenado;
import com.losBicos.ControlTechV1.modelos.SubLocal;
import com.losBicos.ControlTechV1.repositories.AtivoRepository;
import com.losBicos.ControlTechV1.repositories.LocalRepository;
import com.losBicos.ControlTechV1.repositories.UsersRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private AtivoRepository ativoRepository;

    @Autowired
    private LocalRepository localRepository;

    private List<LocalArmazenado> locais;
    private List<Ativos> ativos;
    private int nDeAtivos;
    private List<SubLocal> sublocais;

    private List<Cards> cards;

    public CardService() {
        locais = new ArrayList<>();
        ativos = new ArrayList<>();
        sublocais = new ArrayList<>();
        cards = new ArrayList<>();
    }

    public void carregarDados() {
        // Carregar dados para locais e ativos
        locais = localRepository.findAll();
    }

    public List<Cards> createCard(){
        carregarDados();
        for(LocalArmazenado local : locais){
            List<Ativos> ativosLocal = ativoRepository.findByLocalArmazenado(local.getId());
            double valor = 0.0;

            for (Ativos ativo : ativosLocal) {
                valor += ativo.getValorItem();
            }
            nDeAtivos = ativosLocal.size();
            sublocais.clear();
            sublocais.add(local.getSubLocal());
            Cards card = new Cards(local.getNomelocal(), local.getDescricao(),nDeAtivos, sublocais, valor);
            cards.add(card);
        }
        return cards;
    }
    public int tamanhoLocais() {
        return locais.size();
    }

    public int tamanhoAtivos() {
        return ativos.size();
    }
}
