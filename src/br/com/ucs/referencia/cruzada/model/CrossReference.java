package br.com.ucs.referencia.cruzada.model;

public class CrossReference {
	public Tree first;
	public int size;

	public void addText(Texto text) {
		if(first == null) {
			first = new Tree();
			first.createCrossReference(text);
		} else {
			first.addText(text);
		}
		size++;
	}
	
	public String[] getAllTextTitles() {
		String[] titles = new String[size];
		if(first != null) {
			first.printAllTitles(titles,0);
		}
		return titles;
	}
	
	public Tree getTree(String title) {
		return first.findText(title);
	}
	
	
}
