package br.com.pbldg.apis2.controller;


public class UsuarioMB {
 
	/**
	 * Não vai ser usada
	 */
 
 
 /* 
	private static final long serialVersionUID = 5202799275364383072L;

	@PersistenceContext
	private EntityManager em;
	
	private Usuario usuario;
	
	@PostConstruct
	public void init(){
		this.usuario = new Usuario();
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> getUsuarios() {
		return em.createQuery("select a from Usuario a").getResultList();
 	}
	
	public void salvar(Usuario usuario) {
		
	
		
//		EntityManager em = JPAUtil.getEntityManager();
//		Query q = em.createQuery("select a from Usuario a", Usuario.class);
//		List<Usuario> usuarios = q.getResultList();
//		for (Usuario usuario : usuarios) {
//			System.out.println(usuario.getLogin());
//		}
			
	  parte da inclusão	
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();
	
		try{
			

			this.em.persist(usuario);
			System.out.println("Foi!");
			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	  */
}

	