package br.com.attornatus.services;

import java.text.ParseException;
import java.util.List;

import br.com.attornatus.domain.Endereco;
import br.com.attornatus.domain.Pessoa;
import br.com.attornatus.dto.PessoaDTO;
import br.com.attornatus.dto.PessoaNewDTO;

public interface PessoaService {
	
	public Pessoa findId(Long id);
	public List<Pessoa> findAll();
	public Pessoa update(Pessoa pessoa);
	public Pessoa insert(Pessoa pessoa);
	public void delete(Long id);
	public List<Endereco> findEndereco(Long id);
	public Pessoa fromDTO(PessoaNewDTO objDTO)throws ParseException;
	public Pessoa fromDTO(PessoaDTO objDTO)throws ParseException;
}
