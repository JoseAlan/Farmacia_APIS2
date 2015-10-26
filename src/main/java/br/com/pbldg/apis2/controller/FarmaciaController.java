package br.com.pbldg.apis2.controller;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


import br.com.pbldg.apis2.model.Farmacia;
import br.com.pbldg.apis2.dao.FarmaciaDao;


@Named
@SessionScoped
public class FarmaciaController implements Serializable  {

	private static final long serialVersionUID = 5202799275364383072L;
	
	private Farmacia farmacia;
	private List<Farmacia> listaFarmacias;
	
	@Inject
	private FarmaciaDao farmaciaDao;

	@PostConstruct
	public void init() {
		this.farmacia = new Farmacia();
	}

	public List<Farmacia> getFarmacias() {
		if (this.listaFarmacias == null || this.listaFarmacias.isEmpty()){
			this.listaFarmacias = farmaciaDao.listaFarmacias();
		}
		return this.listaFarmacias;
	}
	
	public List<Farmacia> getListaFarmacias() {
		return listaFarmacias;
	}

	public Farmacia getFarmacia() {
		return farmacia;
	}

	public void setFarmacia(Farmacia farmacia) {
		this.farmacia = farmacia;
	}
	
	public String excluir(Farmacia usuario){
		this.farmaciaDao.excluir(usuario);
		this.listaFarmacias = farmaciaDao.listaFarmacias();
		this.farmacia = new Farmacia();
		return "index?faces-redirect=true";
	}
	
	public String goToPaginaAtualizar(){
		return "pages/farmacia/atualizar?faces-redirect=true";
	}
	public String goToPaginaSalvar(){
		return "pages/farmacia/cadastro?faces-redirect=true";
	}
	public String atualizar(){
		this.farmaciaDao.atualizar(this.farmacia);
		this.farmacia = new Farmacia();
		return "/index?faces-redirect=true";
	}
	
	public String salvar(){
		this.farmaciaDao.salvar(this.farmacia);
		this.listaFarmacias = farmaciaDao.listaFarmacias();
		this.farmacia = new Farmacia();
		return "/index?faces-redirect=true";
	}
	
	public String voltar(){
		return "/index?faces-redirect=true";
	}

	
}
