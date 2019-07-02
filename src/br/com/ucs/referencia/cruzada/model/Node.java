package br.com.ucs.referencia.cruzada.model;

import java.util.List;

public class Node {
	public String word;
	public int count;
	public Node right;
	public Node left;
	
	public Node root;
	
	public Node(String word) {
		this.word = word;
	}
	
	public Node(String word,Node root) {
		this.word = word;
		this.root = root;
		this.count++;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void insert(String wordToInsert) {
		if(wordToInsert.compareTo(this.word) == 0 ) {
			count++;
		} else if(wordToInsert.compareTo(this.word) < 0) {
			if(left == null) {
				System.out.println("inserindo \"" + wordToInsert + "\" na esquerda");
				left = new Node(wordToInsert,this);
			} else {
				left.insert(wordToInsert);
			}
		} else {
			if(right == null) {
				System.out.println("inserindo " + wordToInsert + " na direita");
				this.right = new Node(wordToInsert,this);
			} else {
				right.insert(wordToInsert);
			}
		}
	}

	public int contains(String wordToFind) {
		if(wordToFind.equals(word)) {
			return count;
		} else if(wordToFind.compareTo(this.word) < 0) {
			if(left == null) {
				return 0;
			} else {
				return left.contains(wordToFind);
			}
		} else {
			if(right == null) {
				return 0;
			} else {
				return right.contains(wordToFind);
			}
		}
	}
	
	public int getSize() {
		int leftSize =0;
		int rightSize = 0;
		
		if(this.left != null) {
			leftSize = this.left.getSize();
		}
		
		if(this.right != null) {
			rightSize = this.right.getSize();
		}
		
		return 1 + leftSize + rightSize;
	}

	public void printInOrder() {
		if(left != null) {
			left.printInOrder();
		}
		System.out.println("Palavra = " + word + " -- Aparições =" + count);
		if(right != null) {
			right.printInOrder();
		}
	}
	
	public List<String> getInOrder(List<String> list) {
		if(left != null) {
			left.getInOrder(list);
		}
		list.add("Palavra = " + word + " -- Aparições =" + count) ;
		if(right != null) {
			right.getInOrder(list);
		}
		return list;
	}
	
	
	public void printInPreOrder() {
		System.out.println(word);
		if(left != null) {
			left.printInPreOrder();
		}
		if(right != null) {
			right.printInPreOrder();
		}
	}
	
	
}
