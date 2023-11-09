package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Produto {
    //O ID identifica a chave primaria
	@Id
	//A opcao IDENTITY � para o MySQL
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String dataCompra;
	
	//vou usar o ManyToOne pois esta � a "tabela do muitos" que vai
	//fazer referencia a 1(one) na outra tabela
	@ManyToOne
	//O Join Column vai dizer qual coluna estar� recebendo esta chave
	@JoinColumn(name="LojaOrigem_id")
	private LojaOrigem loja;
	
	
	public Produto() {
		
	}
	


	public Produto(int id, String dataCompra, LojaOrigem loja) {
		super();
		this.id = id;
		this.dataCompra = dataCompra;
		this.loja = loja;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDataCompra() {
		return dataCompra;
	}


	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}


	public LojaOrigem getLoja() {
		return loja;
	}


	public void setLoja(LojaOrigem loja) {
		this.loja = loja;
	}
	
	
}
