package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

public class MenuController implements Initializable{
	@FXML
	private VBox box;

	@FXML
	private JFXButton addText;

	@FXML
	private JFXButton list;

	@FXML
	private JFXButton totalCount;

	@FXML
	private JFXButton totalWords;

	@FXML
	private JFXButton remove;

	@FXML
	private JFXButton preTotal;

	@FXML
	private JFXButton existsWord;

	@FXML
	private JFXButton countWords;

	@FXML
	private JFXButton showWords;

	@FXML
	private JFXButton preOrder;

    @FXML
    void addTextClick(ActionEvent event) {
    	Main.changeScreen("add");
    }

    @FXML
    void listClick(ActionEvent event) {
    	Main.changeScreen("cross");
    }
    
    @FXML
    void existsWordAction(ActionEvent event) {
    	Main.changeScreen("contains");
    }

    @FXML
    void countWordsClick(ActionEvent event) {
    	Main.changeScreen("count");
    }
    

    @FXML
    void listWords(ActionEvent event) {
    	Main.changeScreen("listWords");
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

}
