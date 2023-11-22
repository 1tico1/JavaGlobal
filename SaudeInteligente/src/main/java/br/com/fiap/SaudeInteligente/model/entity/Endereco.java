package br.com.fiap.SaudeInteligente.model.entity;

public class Endereco {
	private long idendereco;
	private String paciente;
	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;
	
	
	public Endereco() {
	}


	public Endereco(long idendereco, String paciente, String logradouro, String numero, String complemento,
			String cep) {
		super();
		this.idendereco = idendereco;
		this.paciente = paciente;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
	}


	public long getIdendereco() {
		return idendereco;
	}


	public void setIdendereco(long idendereco) {
		this.idendereco = idendereco;
	}


	public String getPaciente() {
		return paciente;
	}


	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
