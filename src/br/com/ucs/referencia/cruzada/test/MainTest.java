package br.com.ucs.referencia.cruzada.test;

import java.io.File;
import java.util.List;

import br.com.ucs.referencia.cruzada.controller.TextUtil;
import br.com.ucs.referencia.cruzada.model.Texto;
import br.com.ucs.referencia.cruzada.model.Tree;

public class MainTest {

	public static void main(String[] args) {
		File readFile = TextUtil.readFile();
		String title = TextUtil.getTitle(readFile);
		String content = TextUtil.getContent(readFile);
		String lowerCase = TextUtil.toLowerCase(content);
		TextUtil.getWords(lowerCase);
		
		Texto texto = new Texto(title, content);
		
		Tree tree = new Tree();
		tree.createCrossReference(texto);
		tree.alfabethicalOrder();
		
//		System.out.println(tree.containsWord("teste"));
//		System.out.println(tree.containsWord("um"));
//		
//		System.out.println(tree.countWords());
//		
//		tree.printInPreOrder();
		
		List<String> alfabethicalOrder2 = tree.alfabethicalOrder2();
		System.out.println("alrit");
		for (String string : alfabethicalOrder2) {
			System.out.println("** " + string);
		}
		
	}

}
