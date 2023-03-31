package br.com.attornatus.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.attornatus.domain.Cidade;
import br.com.attornatus.domain.Endereco;
import br.com.attornatus.domain.Estado;
import br.com.attornatus.domain.Pessoa;
import br.com.attornatus.repositories.CidadeRepository;
import br.com.attornatus.repositories.EnderecoRepository;
import br.com.attornatus.repositories.EstadoRepository;
import br.com.attornatus.repositories.PessoaRepository;

@Service
public class DbServiceImpl {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public void instantiateTestDatabase() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		Estado est3 = new Estado(null, "Bahia");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		Cidade c4 = new Cidade(null, "Valença", est3);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		est3.getCidades().addAll(Arrays.asList(c4));

		estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		
		Pessoa pessoa1 = new Pessoa(null, "Sérgio Cardoso", sdf.parse("26/04/1998"));
		
		Endereco e1 = new Endereco(null,"Rua das flores","45400000","10",pessoa1, c1);
		e1.setPrincipal(true);
		
		pessoaRepository.save(pessoa1);
		enderecoRepository.save(e1);
		
		
	}

}
