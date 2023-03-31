package br.com.attornatus.dto;

import java.text.SimpleDateFormat;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.attornatus.domain.Pessoa;

public class PessoaDTO {
	
	private Long id;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=2, max=120, message= "O tamanho deve ser entre 2 e 120")
	private String nome;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String dataDeNascimento;
	
	public PessoaDTO() {
	}

	public PessoaDTO(Pessoa obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.dataDeNascimento = sdf.format(obj.getDataDeNascimento());
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
}
