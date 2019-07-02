package application;

import br.com.ucs.referencia.cruzada.model.CrossReference;
import br.com.ucs.referencia.cruzada.model.Texto;

public class Repository {

	private static CrossReference crossReference = new CrossReference();
	
	public static void addText(String title,String content) {
		Texto text = new Texto(title, content);
		getCrossReference().addText(text);
	}

	public static CrossReference getCrossReference() {
		return crossReference;
	}

}
