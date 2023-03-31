package br.com.attornatus.controller;

import java.net.URI;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.attornatus.domain.Endereco;
import br.com.attornatus.domain.Pessoa;
import br.com.attornatus.dto.PessoaDTO;
import br.com.attornatus.dto.PessoaNewDTO;
import br.com.attornatus.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pessoa> findId(@PathVariable Long id){
		Pessoa obj = service.findId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PessoaDTO>> findAll() {

		List<Pessoa> list = service.findAll();
		List<PessoaDTO> listDTO = list.stream().map(obj -> new PessoaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);

	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PessoaNewDTO objDTO) throws ParseException {
		Pessoa obj = service.fromDTO(objDTO);
		obj.setId(null);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PessoaDTO objDto, @PathVariable Long id) throws ParseException {
		Pessoa obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}/enderecos", method = RequestMethod.GET)
	public ResponseEntity<List<Endereco>> findEndereco(@PathVariable Long id) {
		List<Endereco> obj = service.findEndereco(id);
		return ResponseEntity.ok().body(obj);
	}
}
