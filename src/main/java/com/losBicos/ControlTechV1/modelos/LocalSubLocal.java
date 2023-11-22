package com.losBicos.ControlTechV1.modelos;

public class LocalSubLocal {
    private LocalArmazenado local;
    private SubLocal sublocal;

    public LocalSubLocal() {
    }

    public LocalSubLocal(LocalArmazenado local, SubLocal sublocal) {
        this.local = local;
        this.sublocal = sublocal;
    }

    public String imprimir(){
        return "local  " + local.getNomelocal() + "Sub " + sublocal.getNomelocal();
    }
    public LocalArmazenado getLocal() {
        return local;
    }

    public void setLocal(LocalArmazenado local) {
        this.local = local;
    }

    public SubLocal getSublocal() {
        return sublocal;
    }

    public void setSublocal(SubLocal sublocal) {
        this.sublocal = sublocal;
    }
}
