package br.com.pbldg.apis2.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.com.pbldg.apis2.model.Farmacia;


@Dependent
public class FarmaciaDao implements Serializable{

	private static final long serialVersionUID = 5233215231835772290L;
	
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void excluir(Farmacia farmacia) {
		this.em.remove(this.em.contains(farmacia) ? farmacia : this.em.merge(farmacia) );
	}

	@SuppressWarnings("unchecked")
	public List<Farmacia> listaFarmacias() {
		return this.em.createQuery("select u from Farmacia u").getResultList();
	}
	
	@Transactional
	public void salvar(Farmacia farmacia) {
		this.em.merge(farmacia);
	}

	@Transactional
	public void atualizar(Farmacia farmacia) {
		this.em.merge(farmacia);
	}
}
