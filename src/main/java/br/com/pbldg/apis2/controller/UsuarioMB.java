package br.com.pbldg.apis2.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pbldg.apis2.dao.JPAUtil;
import br.com.pbldg.apis2.model.Usuario;

@ManagedBean(name="usuarioMB")
@RequestScoped
public class UsuarioMB implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5202799275364383072L;
	
	private String nome;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void salvar() {
		System.out.println("Foi!");
		
//		EntityManager em = JPAUtil.getEntityManager();
//		Query q = em.createQuery("select a from Usuario a", Usuario.class);
//		List<Usuario> usuarios = q.getResultList();
//		for (Usuario usuario : usuarios) {
//			System.out.println(usuario.getLogin());
//		}
	}
	
}
