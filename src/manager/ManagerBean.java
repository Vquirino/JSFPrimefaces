package manager;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import entity.Produto;

@ManagedBean(name = "mb")
@RequestScoped
public class ManagerBean {

	private List<SelectItem> itens; // vitrine - conteudo do checkbox
	private List<Produto> produtos; // produtos construtor que esta na tela
	private List<Produto> cesta; // começa vazio, serão marcados
	private List<String> escolha; // checkbox
	private Double mbTotal = 0.;

	public ManagerBean() {
		escolha = new ArrayList<String>();
		itens = new ArrayList<SelectItem>();
		produtos = new ArrayList<Produto>();
		cesta = new ArrayList<Produto>();

		// LISTA DE PRODUTO MOCKADO - VITRINE
		// LISTA DE PRODUTO CHEIA
		produtos.add(new Produto(001, "havaiana", 40.,
				"https://ph-cdn1.ecosweb.com.br/imagens01/foto/calcado-feminino/chinelo/chinelo-havaianas-slim-floral-preta_313148_600_3.jpg"));
		produtos.add(new Produto(002, "mascara", 20.,
				"https://fisiostore.vteximg.com.br/arquivos/ids/161556-1000-1000/mascara-respiratoria-reutilizavel-sigvaris-care-preta.jpg?v=637251397284230000"));
		produtos.add(new Produto(003, "casaco", 150.,
				"https://static.netshoes.com.br/produtos/moleton-puma-logo-crew-sweat-tr-big-log-masculino/06/D14-9553-006/D14-9553-006_zoom1.jpg?ts=1587747787&ims=544x"));
		produtos.add(new Produto(004, "caneca", 15.,
				"https://a-static.mlcdn.com.br/1500x1500/caneca-o-pequeno-principe-canencacomestampa/canecacomestampa/5812533024/36f34a6d172349e0f4bfdb9abc60b317.jpg"));

	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Produto> getCesta() {
		return cesta;
	}

	public void setCesta(List<Produto> cesta) {
		this.cesta = cesta;
	}

	public Double getMbTotal() {
		return mbTotal;
	}

	public void setMbTotal(Double mbTotal) {
		this.mbTotal = mbTotal;
	}

	public List<SelectItem> getItens() {
		if (itens == null) {
			itens = new ArrayList<SelectItem>();
		}

		// SELECTITEM - ELE É O PRÓPRIO CHECKBOX
		for (Produto x : produtos) {
			SelectItem item = new SelectItem(x, x.getNome() + "-" + x.getPreco());
			itens.add(item);
		}
		return itens;
	}

	public void setItens(List<SelectItem> itens) {
		this.itens = itens;
	}
		
	public List<String> getEscolha() {
		return escolha;
	}

	public void setEscolha(List<String> escolha) {
		this.escolha = escolha;
	}

	
	public void processo() {
		FacesContext fc = FacesContext.getCurrentInstance();
		cesta.clear();
		// ESCOLHA É O CAMPO DO CHECKBOX (lista de String)
		for (String x : escolha) {
			String vetor[] = x.split(",");
			cesta.add(new Produto(new Integer(vetor[0]), vetor[1], new Double(vetor[2]), vetor[3] ));
			mbTotal += new Double(vetor[2]);
		}
		fc.addMessage(null, new FacesMessage("Cesta de compras" + cesta));
	}
	
	

}
