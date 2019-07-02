package application;

import java.io.IOException;

import br.com.ucs.referencia.cruzada.model.CrossReference;
import br.com.ucs.referencia.cruzada.model.Texto;
import br.com.ucs.referencia.cruzada.model.Tree;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private static Stage stage;

	private static Scene crossReference;
	private static Scene addText;
	private static Scene containsWord;
	private static Scene countWords;
	private static Scene showWordsInOrder;
	private static Scene showWordsPreOrder;

	public static Repository repository;

	@Override
	public void start(Stage primaryStage) throws IOException {
		stage = primaryStage;
		primaryStage.setTitle("Referencia Cruzada");
//
//		Parent fxmlCrossReference = FXMLLoader.load(getClass().getResource("CrossReference.fxml"));
//		crossReference = new Scene(fxmlCrossReference);

		Parent fxmlAddText = FXMLLoader.load(getClass().getResource("AddText.fxml"));
		addText = new Scene(fxmlAddText);

//		Parent fxmlContainsWord = FXMLLoader.load(getClass().getResource("ContainsWord.fxml"));
//		containsWord = new Scene(fxmlContainsWord);

//		Parent fxmlCountWords = FXMLLoader.load(getClass().getResource("CountWords.fxml"));
//		countWords = new Scene(fxmlCountWords);
		primaryStage.setScene(addText);
		primaryStage.show();

		repository = new Repository();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static void changeScreen(String view) {
		try {
			switch (view) {
			case "add":
				stage.setScene(addText);
				break;
			case "contains":
				Parent fxmlContainsWord = FXMLLoader.load(Main.class.getResource("ContainsWord.fxml"));
				containsWord = new Scene(fxmlContainsWord);
				stage.setScene(containsWord);
				break;
			case "count":
				Parent fxmlCountWords = FXMLLoader.load(Main.class.getResource("CountWords.fxml"));
				countWords = new Scene(fxmlCountWords);
				stage.setScene(countWords);
				break;

			case "cross":
				Parent fxmlCrossReference = null;
				fxmlCrossReference = FXMLLoader.load(Main.class.getResource("CrossList.fxml"));

				crossReference = new Scene(fxmlCrossReference);
				stage.setScene(crossReference);
				break;
			case "listWords":
				Parent fxmlWordsInOrder = null;
				fxmlWordsInOrder = FXMLLoader.load(Main.class.getResource("ListInOrder.fxml"));

				showWordsInOrder = new Scene(fxmlWordsInOrder);
				stage.setScene(showWordsInOrder);
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
