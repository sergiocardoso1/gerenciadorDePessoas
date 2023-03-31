package br.com.attornatus.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class PessoaNewDTO {

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 2, max = 120, message = "O tamanho deve ser entre 2 e 120")
	private String nome;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String dataDeNascimento;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String logradouro;
	@NotEmpty(message = "Preenchimento obrigatório")
	private String cep;
	@NotEmpty(message = "Preenchimento obrigatório")
	private String numero;

	private Long cidadeId;

	private String logradouro2;
	private String cep2;
	private String numero2;
	private Long cidadeId2;

	public PessoaNewDTO() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Long getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Long cidadeId) {
		this.cidadeId = cidadeId;
	}

	public String getLogradouro2() {
		return logradouro2;
	}

	public void setLogradouro2(String logradouro2) {
		this.logradouro2 = logradouro2;
	}

	public String getCep2() {
		return cep2;
	}

	public void setCep2(String cep2) {
		this.cep2 = cep2;
	}

	public String getNumero2() {
		return numero2;
	}

	public void setNumero2(String numero2) {
		this.numero2 = numero2;
	}

	public Long getCidadeId2() {
		return cidadeId2;
	}

	public void setCidadeId2(Long cidadeId2) {
		this.cidadeId2 = cidadeId2;
	}

}
