package model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CarrinhoCompra {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String dataCompra;
	
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	public CarrinhoCompra() {
		
	}
	

	public CarrinhoCompra(int id, String string, Produto produto, Cliente cliente) {
		super();
		this.id = id;
		this.dataCompra = string;
		this.produto = produto;
		this.cliente = cliente;
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


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	
	
}
