package com.losBicos.ControlTechV1.modelos;

public class AtivoMiddleWare {
    private Ativos ativos;

    private Software software;

    private LocalArmazenado local;

    public AtivoMiddleWare() {
    }

    public AtivoMiddleWare(Ativos ativos) {
        this.ativos = ativos;
    }

    public AtivoMiddleWare(Ativos ativos, Software software) {
        this.ativos = ativos;
        this.software = software;
    }


    public AtivoMiddleWare(Ativos ativos, Software software, LocalArmazenado local) {
        this.ativos = ativos;
        this.software = software;

        this.local = local;
    }

    public Ativos getAtivos() {
        return ativos;
    }

    public void setAtivos(Ativos ativos) {
        this.ativos = ativos;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }


    public LocalArmazenado getLocal() {
        return local;
    }

    public void setLocal(LocalArmazenado local) {
        this.local = local;
    }
}
