package br.com.pbldg.apis2.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.com.pbldg.apis2.model.Usuario;

@Dependent
public class UsuarioDao implements Serializable {

	private static final long serialVersionUID = 5233215231835772290L;
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void excluir(Usuario usuario) {
		this.em.remove(this.em.contains(usuario) ? usuario : this.em.merge(usuario) );
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listaUsuarios() {
		return this.em.createQuery("select u from Usuario u").getResultList();
	}
	
	@Transactional
	public void salvar(Usuario usuario) {
		this.em.merge(usuario);
	}

	@Transactional
	public void atualizar(Usuario usuario) {
		this.em.merge(usuario);
	}
	
	@Transactional
	public Usuario getUsuario(String login, String senha){
		
		try{
		Usuario usuario = (Usuario) this.em.createQuery( "SELECT u from Usuario u where u.login = :login and u.senha = :senha") .setParameter("login", login) .setParameter("senha", senha).getSingleResult(); 
		
		return usuario;
		} catch (Exception e) { 
			return null; 
			
		}

	
	}	
	
}