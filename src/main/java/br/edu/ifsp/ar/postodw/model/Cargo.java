package br.edu.ifsp.ar.postodw.model;

public enum Cargo {
    FRENTISTA("Frentista"),
    GERENTE("Gerente"),
    CAIXA("Caixa"),
    SERVICOS_GERAIS("Serviços Gerais"),
    SEGURANCA("Segurança"),
    ATENDENTE("Atendente"),
    OUTRO("Outro");


    private String description;

    private Cargo(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
