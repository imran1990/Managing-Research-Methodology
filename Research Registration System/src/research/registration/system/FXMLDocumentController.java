/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package research.registration.system;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author shuvo
 */
public class FXMLDocumentController implements Initializable {
    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ChairmanHomeButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ChairmanLogInPanel.fxml"));
        
        Scene scene= new Scene(root);
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void FacultyHomeButtonAction(ActionEvent event) throws IOException {
        
         Parent root = FXMLLoader.load(getClass().getResource("FacultyLogInPanel.fxml"));
        
        Scene scene= new Scene(root);
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void StudentHomeButtonAction(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("LoginPannel.fxml"));
        
        Scene scene= new Scene(root);
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.show();
        
    }
    
}
