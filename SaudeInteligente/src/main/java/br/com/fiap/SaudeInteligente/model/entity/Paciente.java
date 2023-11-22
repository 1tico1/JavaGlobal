package br.com.fiap.SaudeInteligente.model.entity;

import jakarta.validation.constraints.NotBlank;

public class Paciente {
	private long id;
	@NotBlank
	private String nome;
	@NotBlank
    private String cpf;
	@NotBlank
	private String dataNascimento;
	@NotBlank
	private String sexo;
	@NotBlank
	private String endereco;
	@NotBlank
	private String telefone;
	@NotBlank
	private String email;
	@NotBlank
	private String doencas;
	
    private Medico medico;

	
	public Paciente(long id, @NotBlank String nome, @NotBlank String cpf, @NotBlank String dataNascimento, @NotBlank String sexo, @NotBlank String endereco, @NotBlank
			String telefone, @NotBlank String email, @NotBlank String doencas) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.doencas = doencas;
	}

	public Paciente() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDoencas() {
		return doencas;
	}

	public void setDoencas(String doencas) {
		this.doencas = doencas;
	}
    
    
    
	public void associarMedico(Medico medico) {
        this.setMedico(medico);
        medico.adicionarPaciente(this);
    }

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
    
    
    
    
    
    
}
