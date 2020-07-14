package br.com.academia.domain.aluno;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

//usamos também o  @Stateful
//classe para implementar o negocio
//faz o acesso ao banco. 
//o ejb stateless não mantem estado
//tudo que vc executar tem que ser terminado nesse metodo. 
//não se usa atributos. 
//e fetio o rolbeck se necessario. 
//
@Stateless
public class EstadoRepository {

	@PersistenceContext
	private EntityManager em;
	
	public List<Estado> listaEstados(){
		TypedQuery<Estado> q = em.createQuery("Select e From Estado e ORDER BY e.nome", Estado.class);
		return q.getResultList();
	}
}
