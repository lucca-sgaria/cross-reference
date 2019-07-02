package br.com.ucs.referencia.cruzada.model;

import java.util.ArrayList;
import java.util.List;

import br.com.ucs.referencia.cruzada.controller.TextUtil;

public class Tree {
	private Node root;
	private String title;
	
	private Tree next;

	public void createCrossReference(Texto texto) {
		this.title = texto.getTitulo();
		System.out.println("titulo " + title);
		String conteudo = texto.getConteudo();
		String[] words = TextUtil.getWords(conteudo);

		if (root == null) {
			System.out.println("setando raiz " + words[0]);
			this.root = new Node(words[0]);
			this.root.setCount(1);

			for (int i = 1; i < words.length; i++) {
				this.root.insert(words[i]);
			}
		}
	}

	public int containsWord(String word) {
		if (root != null) {
			return root.contains(word);
		}
		return 0;
	}

	public boolean removeWordNode(String word) {
		if (root == null) {
			return false;
		}

		if (containsWord(word) == 0) {
			return false;
		}
		return true;
	}

	public int countWords() {
		if (root == null) {
			return 0;
		}

		return root.getSize();
	}

	public void alfabethicalOrder() {
		if (root != null) {
			root.printInOrder();
		}
	}
	
	public List<String> alfabethicalOrder2() {
		List<String> list = new ArrayList<>();
		if (root != null) {
			list = root.getInOrder(list);
		}
		return list;
	}


	public void printInPreOrder() {
		if (root != null) {
			root.printInPreOrder();
		}
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Tree getNext() {
		return next;
	}

	public void setNext(Tree next) {
		this.next = next;
	}

	public boolean addText(Texto text) {
		if (this.next == null) {
			System.out.println("criando texto novo");
			next = new Tree();
			next.createCrossReference(text);
			return true;
		} else {
			System.out.println("chamando proximo");
			next.addText(text);
		}
		return false;
	}

	public void printAllTitles(String[] vector, int i) {
		vector[i] = this.title;
		if (next != null) {
			next.printAllTitles(vector, i + 1);
		}
	}

	public Tree findText(String title) {
		if(this.title.equals(title)) {
			return this;
		} else if(next != null) {
			return next.findText(title);
		} 
		return null;
		
	}

}
