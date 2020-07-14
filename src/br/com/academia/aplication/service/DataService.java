package br.com.academia.aplication.service;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.academia.domain.aluno.Estado;
import br.com.academia.domain.aluno.EstadoRepository;
import br.com.academia.domain.aluno.Aluno.Sexo;
import br.com.academia.domain.aluno.Aluno.Situacao;

// usamos tamb�m o  @Stateful
// classe para implementar o negocio
// faz o acesso ao banco. 
// o ejb stateless n�o mantem estado
// tudo que vc executar tem que ser terminado nesse metodo. 
// n�o se usa atributos. 
// e fetio o rolbeck se necessario. 
//
@Stateless
public class DataService {

	@EJB
	private EstadoRepository estadoRepository;
	public List<Estado> listaEstados(){
		return estadoRepository.listaEstados();
	}
	
	public Sexo[] getSexos() {
		return Sexo.values();
	}
	
	public Situacao[] getSituacoes() {
		return Situacao.values();
	}

}
