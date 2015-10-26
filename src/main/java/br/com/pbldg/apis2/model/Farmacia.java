package br.com.pbldg.apis2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FARMACIA", schema="apis2")
@SequenceGenerator(name = "FarmaciaSequence", sequenceName = "SQ_ID_FARMACIA", allocationSize = 1)
public class Farmacia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FarmaciaSequence")
	private Long id;

    @Column(name = "NOME", length = 30, nullable = false)
    private String nome;
    
    @Column(name = "ENDERECO", length = 50, nullable = false)
    private String endereco;
    
    @Column(name = "NUMERO", length = 10, nullable = false)
    private String numero;

	@Column(name = "BAIRRO", length = 30, nullable = false)
    private String bairro;
    
    @Column(name = "CIDADE", length = 30, nullable = false)
    private String cidade;
    
    @Column(name = "TELEFONE", length = 30, nullable = false)
    private Integer telefone;
      
    @Column(name = "HORARIO", length = 30, nullable = false)
    private String horario;
	
    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;
    
    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	 public String getNumero() {
			return numero;
	}

	 public void setNumero(String numero) {
			this.numero = numero;
	}

	public String getCidade() {
			return cidade;
	}

		public void setCidade(String cidade) {
			this.cidade = cidade;
	}
 
}
