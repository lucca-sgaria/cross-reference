package teste;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class TestC implements Initializable {

	@FXML
	private ListView<String> lview;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> items = FXCollections.observableArrayList("Single", "Double", "Suite", "Family App");
		lview.setItems(items);
	}

}
