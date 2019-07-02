package teste;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent fxmlCountWords = FXMLLoader.load(getClass().getResource("Test.fxml"));
		Scene test = new Scene(fxmlCountWords);

		primaryStage.setScene(test);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
