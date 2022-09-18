package br.com.prova.Processos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.prova.Processos.Repository.ProcessoRepository;
import br.com.prova.Processos.modelo.Processo;

@RestController
@RequestMapping("api/processo")
public class ControladorProcesso {

	@Autowired
	private ProcessoRepository processoRepository;
	
	public ControladorProcesso(ProcessoRepository processoRepository) {
		super();
		this.processoRepository = processoRepository;
	}
	
	@PostMapping
	public ResponseEntity<Processo> save(@RequestBody Processo processo){
		processoRepository.save(processo);
		return new ResponseEntity<>(processo, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Processo>> getAll(){
		List<Processo> processos = new ArrayList<>();
		processos = processoRepository.findAll();
		return new ResponseEntity<>(processos, HttpStatus.OK);
		}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Optional<Processo>> getById(@PathVariable Long id){
		Optional<Processo> processo;
		try {
			processo = processoRepository.findById(id);
			return new ResponseEntity<Optional<Processo>>(processo, HttpStatus.OK);
		}catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Processo>>(HttpStatus.NOT_FOUND);
			
		}
	}
		
		
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Optional<Processo>> deleteById(@PathVariable Long id){
		try {
			processoRepository.deleteById(id);
			return new ResponseEntity<Optional<Processo>>(HttpStatus.OK);
		}catch(NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Processo>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Processo> updateProcesso(@PathVariable Long id, @RequestBody Processo newProcesso){
		return processoRepository.findById(id).map(processo ->{
			processo.setNumero(newProcesso.getNumero());
			processo.setPessoa(newProcesso.getPessoa());
			processo.setAno(newProcesso.getAno());
			processo.setDataCadastro(newProcesso.getDataCadastro());
			processo.setId(newProcesso.getId());
			Processo processoUdated = processoRepository.save(processo);
			return ResponseEntity.ok().body(processoUdated);
		}).orElse(ResponseEntity.notFound().build());
	}
}
