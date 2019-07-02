package application;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;

import br.com.ucs.referencia.cruzada.model.Tree;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class CountWordsController implements Initializable {
	

    @FXML
    private BorderPane border;

    @FXML
    private Label count;

    @FXML
    private JFXComboBox<String> cbox;
    
    private String param;

    @FXML
    void countOFWords(ActionEvent event) {
	System.out.println("countWords --");
		
		Tree tree = Repository.getCrossReference().getTree(param);
		
		int countWords = tree.countWords();
		
		count.setText(String.valueOf(countWords));
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
			
			cbox.valueProperty().addListener((ov,t,t1) -> {
				param = ov.getValue();
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
