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
public class LoginPannelController implements Initializable {
  private final String DB_USERNAME = "imran";
   private final String DB_PASSWORD = "12345";
   private final String DB_HOSTNAME = "localhost";
   private final String DB_DBNAME = "research";
   private final String DB_URL = "jdbc:mysql://"+DB_HOSTNAME+"/"+DB_DBNAME;
    @FXML
    private TextField IdDisplayfield;
    @FXML
    private TextField PasswordDisplayfield;
    @FXML
    private Label notification;
    @FXML
    private AnchorPane loginPannel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LoginButtonAction(ActionEvent event) throws IOException {
        ArrayList<student>tpassList = new ArrayList<>();
            try{
                Connection connection = (Connection) DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                Statement statement = (Statement) connection.createStatement();
                String query = "select * from student;";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                   Integer stuId = resultSet.getInt("id");
                    String password = resultSet.getString("password");
                    student t = new student(stuId,password);
                    tpassList.add(t);
                    }
                }catch(SQLException sqle){
                System.err.println("sqle");}
            
            
            Integer stuId= Integer.parseInt(IdDisplayfield.getText());
            String password =PasswordDisplayfield.getText();
            for(int i=0;i<tpassList.size();i++)
            { if(stuId.equals(tpassList.get(i).getId()) && password.equals(tpassList.get(i).getPass())) 
                      { 
                          AnchorPane pane =FXMLLoader.load(getClass().getResource("StudentApplypanel.fxml"));
                          loginPannel.getChildren().setAll(pane);
                        
                      notification.setText("  ");
                      } 
            if(!stuId.equals(tpassList.get(i).getId()) || !password.equals(tpassList.get(i).getPass()))
                  {notification.setText("credintial is not correct");}
            } 
            
            IdDisplayfield.clear();
            PasswordDisplayfield.clear();
     
    }
    
}
