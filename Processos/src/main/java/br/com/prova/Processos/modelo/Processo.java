package br.com.prova.Processos.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Processo{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private Integer ano;
    private LocalDate dataCadastro;
    @OneToOne
    private Pessoa pessoa;
    
	@Override
	public int hashCode() {
		return Objects.hash(ano, dataCadastro, id, numero, pessoa);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Processo other = (Processo) obj;
		return Objects.equals(ano, other.ano) && Objects.equals(dataCadastro, other.dataCadastro)
				&& Objects.equals(id, other.id) && Objects.equals(numero, other.numero)
				&& Objects.equals(pessoa, other.pessoa);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro = LocalDate.now();
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}