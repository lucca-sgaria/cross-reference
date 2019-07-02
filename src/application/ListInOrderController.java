package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;

import br.com.ucs.referencia.cruzada.model.Tree;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ListInOrderController implements Initializable {

	@FXML
	private BorderPane border;

	@FXML
	private Label count;

	@FXML
	private JFXComboBox<String> cbox;

	@FXML
	private ListView<String> list;

	private String param;

	ObservableList<String> items = FXCollections.observableArrayList(new ArrayList<>());

	@FXML
	void listWords(ActionEvent event) {
		if (param != null) {
			Tree tree = Repository.getCrossReference().getTree(param);
			List<String> alfabethicalOrder2 = tree.alfabethicalOrder2();
			items.setAll(alfabethicalOrder2);
			list.setItems(items);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			VBox box = FXMLLoader.load(getClass().getResource("DrawerContent.fxml"));
			border.setLeft(box);

			String[] allTextTitles = Repository.getCrossReference().getAllTextTitles();
			List<String> asList = Arrays.asList(allTextTitles);

			ObservableList<String> items = FXCollections.observableArrayList(asList);
			cbox.setItems(items);
			cbox.valueProperty().addListener((ov, t, t1) -> {
				param = ov.getValue();
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
