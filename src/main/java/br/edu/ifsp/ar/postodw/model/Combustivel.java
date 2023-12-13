package br.edu.ifsp.ar.postodw.model;

public enum Combustivel {
    GASOLINA_COMUM("Gasolina Comum"),
    GASOLINA_ADITIVADA("Gasolina Aditivada"),
    GASOLINA_PREMIUM("Gasolina Premium"),
    ETANOL("Etanol"),
    DIESEL("Diesel"),
    GNV("GNV");

    private String description;

    private Combustivel(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
