package br.com.prova.Processos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prova.Processos.modelo.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	List<Pessoa> findBynome(String nome);


	
}

		

