package application;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class CrossListController implements Initializable{
   
    @FXML
    private BorderPane border;
    
    @FXML
    private ListView<String> lview;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			VBox box = FXMLLoader.load(getClass().getResource("DrawerContent.fxml"));
			border.setLeft(box);
			
			String[] allTextTitles = Repository.getCrossReference().getAllTextTitles();
			List<String> asList = Arrays.asList(allTextTitles);

				
			ObservableList<String> items = FXCollections.observableArrayList(asList);
			lview.setItems(items);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
