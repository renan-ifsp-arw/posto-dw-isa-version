package br.edu.ifsp.ar.postodw.repository.fliter;

import javax.validation.constraints.Pattern;



public class ClienteFilter {

	
	
	private String nome;

    @Pattern(regexp = "\\d{11}|\\d{14}")
    private String documento;

    
    
    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	
}
