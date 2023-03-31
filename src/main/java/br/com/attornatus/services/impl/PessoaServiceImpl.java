package br.com.attornatus.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.attornatus.domain.Cidade;
import br.com.attornatus.domain.Endereco;
import br.com.attornatus.domain.Pessoa;
import br.com.attornatus.dto.PessoaDTO;
import br.com.attornatus.dto.PessoaNewDTO;
import br.com.attornatus.repositories.EnderecoRepository;
import br.com.attornatus.repositories.PessoaRepository;
import br.com.attornatus.services.PessoaService;
import br.com.attornatus.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaServiceImpl implements PessoaService{

	@Autowired
	private PessoaRepository repository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Pessoa findId(Long id) {
		Optional<Pessoa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Pessoa não encontrada! Id: " + id + ", Tipo: " + Pessoa.class.getName()));
	}

	@Override
	public List<Pessoa> findAll() {
		return repository.findAll();
	}

	@Override
	public Pessoa update(Pessoa pessoa) {
		Pessoa newObj = findId(pessoa.getId());
		updateData(newObj, pessoa);
		return repository.save(newObj);
		
		
	}

	@Override
	public Pessoa insert(Pessoa pessoa) {
		pessoa.setId(null);
		pessoa = repository.save(pessoa);
		enderecoRepository.saveAll(pessoa.getEndereco());
		return pessoa;
	}

	@Override
	public void delete(Long id) {
		findId(id);
		repository.deleteById(id);
		
		
	}
	
	public List<Endereco> findEndereco(Long id){
		Pessoa obj = findId(id);
		return obj.getEndereco();
	}
	
	public Pessoa fromDTO(PessoaNewDTO objDTO) throws ParseException {
		Pessoa pessoa = new Pessoa(null, objDTO.getNome(), sdf.parse(objDTO.getDataDeNascimento()));
		Cidade cidade = new Cidade(objDTO.getCidadeId(), null, null);
		Endereco endereco = new Endereco(null, objDTO.getLogradouro(), objDTO.getCep(), objDTO.getNumero(), pessoa, cidade);
		endereco.setPrincipal(true);
		pessoa.getEndereco().add(endereco);
		if(objDTO.getCidadeId2() != null) {
			Cidade cidade2 = new Cidade(objDTO.getCidadeId2(), null, null);
			if(objDTO.getLogradouro2() != null && objDTO.getCep2() != null && objDTO.getNumero2() != null) {
				Endereco endereco2 = new Endereco(null, objDTO.getLogradouro2(), objDTO.getCep2(), objDTO.getNumero2(), pessoa, cidade2);
				pessoa.getEndereco().add(endereco2);
			}
		}
		return pessoa;
	}
	
	public Pessoa fromDTO(PessoaDTO objDTO) throws ParseException {
		return new Pessoa(objDTO.getId(), objDTO.getNome(), sdf.parse(objDTO.getDataDeNascimento()));
	}

	private void updateData(Pessoa newObj, Pessoa obj) {
		newObj.setNome(obj.getNome());
		newObj.setDataDeNascimento(obj.getDataDeNascimento());
	}
}
