package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import br.com.ucs.referencia.cruzada.controller.TextUtil;
import br.com.ucs.referencia.cruzada.model.CrossReference;
import br.com.ucs.referencia.cruzada.model.Texto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

public class AddController implements Initializable{
   
    @FXML
    private BorderPane border;
    
	@FXML
    private Button find;
	
    @FXML
    private JFXTextField title;

    @FXML
    private JFXTextArea content;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			VBox box = FXMLLoader.load(getClass().getResource("DrawerContent.fxml"));
			border.setLeft(box);
			
			FileChooser fileChooser = new FileChooser();
			find.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
				File showOpenDialog = fileChooser.showOpenDialog(border.getScene().getWindow());
				
				
				String title = TextUtil.getTitle(showOpenDialog);
				this.title.setText(title);
				
				String content2 = TextUtil.getContent(showOpenDialog);
				this.content.setText(content2);
				
				Repository.addText(title, content2);
				
			});
			
			this.title.clear();
			this.content.clear();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
