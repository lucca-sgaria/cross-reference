package br.com.ucs.referencia.cruzada.test;

import br.com.ucs.referencia.cruzada.model.CrossReference;
import br.com.ucs.referencia.cruzada.model.Texto;

public class BiggerTest {
	public static void main(String[] args) {
		CrossReference c = new CrossReference();
		Texto text = new Texto("texto1", "esse1 esseOne");
		Texto text2 = new Texto("texto2", "esse2");
		Texto text3 = new Texto("texto3", "esse3");
		Texto text4 = new Texto("texto4", "esse4");
		System.out.println("addin 1");
		c.addText(text);
		System.out.println("addin 2");
		c.addText(text2);
		System.out.println("addin 3");
		c.addText(text3);
		System.out.println("addin 4");
		c.addText(text4);
		
		String[] allTextTitles = c.getAllTextTitles();
		for (int i = 0; i < allTextTitles.length; i++) {
			System.out.println("Titulo :" + allTextTitles[i]);
		}
		
		System.out.println("find2 " + c.getTree("texto2").getTitle());
		
		try {
			System.out.println("findxa " + c.getTree("xa").getTitle());
		} catch (NullPointerException e) {
			System.out.println("nullll right");
		}
		
		System.out.println("find4 " + c.getTree("texto4").getTitle());
	}
	
	
}
