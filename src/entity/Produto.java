package entity;

public class Produto {
	
	private Integer codigo;
	private String nome;
	private Double preco;
	private String imagem;
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}
	
	public Produto(Integer codigo, String nome, Double preco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
	}


	public Produto(Integer codigo, String nome, Double preco, String imagem) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.imagem = imagem;
	}

	@Override
	public String toString() {
		return codigo + "," + nome + "," + preco + "," + imagem;
	}


	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	
	

}
