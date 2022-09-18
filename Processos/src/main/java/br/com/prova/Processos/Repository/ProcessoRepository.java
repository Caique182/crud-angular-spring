package br.com.prova.Processos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prova.Processos.modelo.Pessoa;
import br.com.prova.Processos.modelo.Processo;

public interface ProcessoRepository extends JpaRepository<Processo, Long> {

}
