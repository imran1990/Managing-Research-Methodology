    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package research.registration.system;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author shuvo
 */
public class ChairmanLogInPanelController implements Initializable {
    
   private final String DB_USERNAME = "imran";
   private final String DB_PASSWORD = "12345";
   private final String DB_HOSTNAME = "localhost";
   private final String DB_DBNAME = "research";
   private final String DB_URL = "jdbc:mysql://"+DB_HOSTNAME+"/"+DB_DBNAME;

    @FXML
    private AnchorPane LoginPannel;
    @FXML
    private Label notification;
    @FXML
    private TextField InitialDisplayField;
    @FXML
    private TextField PasswordDisplayField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LogInButtonAction(ActionEvent event) throws IOException {
        
         ArrayList<Chairman>tpassList = new ArrayList<>();
            try{
                Connection connection = (Connection) DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                Statement statement = (Statement) connection.createStatement();
                String query = "select * from Chairman;";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    String initial = resultSet.getString("initial");
                    String password = resultSet.getString("password");
                    Chairman c = new Chairman(initial,password);
                    tpassList.add(c);
                    }
                }catch(SQLException sqle){
                System.err.println("sqle");}
            
            
            String initial= InitialDisplayField.getText();
            String password =PasswordDisplayField.getText();
            for(int i=0;i<tpassList.size();i++)
            { if(initial.equals(tpassList.get(i).getInitial()) && password.equals(tpassList.get(i).getPassword())) 
                      { 
                          AnchorPane pane =FXMLLoader.load(getClass().getResource("chairmanApprove.fxml"));
                          LoginPannel.getChildren().setAll(pane);
                        
                      notification.setText("  ");
                      } 
            if(initial.equals(tpassList.get(i).getInitial()) && password.equals(tpassList.get(i).getPassword()))
                  {notification.setText("credintial is not correct");}
            } 
            
            InitialDisplayField.clear();
            PasswordDisplayField.clear();
     
    }
    
}
