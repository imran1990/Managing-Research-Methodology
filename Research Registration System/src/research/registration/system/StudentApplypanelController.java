/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package research.registration.system;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shuvo
 */
public class StudentApplypanelController implements Initializable {
    private final String DB_USERNAME = "imran";
   private final String DB_PASSWORD = "12345";
   private final String DB_HOSTNAME = "localhost";
   private final String DB_DBNAME = "research";
   private final String DB_URL = "jdbc:mysql://"+DB_HOSTNAME+"/"+DB_DBNAME;


    @FXML
    private Label notification;
    @FXML
    private Button s;
    @FXML
    private TextField idField;
    @FXML
    private Label notification1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ApplyButtonAction(ActionEvent event)throws IOException {
        
         Parent root = FXMLLoader.load(getClass().getResource("ApplyForm.fxml"));
        
        Scene scene= new Scene(root);
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void seeNotificationButtonAction(ActionEvent event){ 
        Integer i = Integer.parseInt(idField.getText());
        ArrayList<Registration>appList = new ArrayList<>();
            try{
                com.mysql.jdbc.Connection connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                com.mysql.jdbc.Statement statement = (com.mysql.jdbc.Statement) connection.createStatement();
                String query = "select * from registration where id1 = "+i+";";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                   String initial = resultSet.getString("initial");
                    String topic = resultSet.getString("topicname");
                    Integer s1 = resultSet.getInt("id1");
                    Integer s2 = resultSet.getInt("id2");
                    Integer s3 = resultSet.getInt("id3");
                    String sta = resultSet.getString("status");
                    String msg = resultSet.getString("chairmanmsg");
                    Registration t = new Registration(initial,topic,s1, s2, s3, sta, msg);
                    appList.add(t);
                    }
                }catch(SQLException sqle){
                System.err.println("sqle");}
                String status = appList.get(0).getCmsg();
                
                if(status.equals("ok"))
                    notification.setText("application is approved");
                else if(status.equals("not"))
                    notification.setText("application is rejected");
                else if(status.equals("null"))
                    notification.setText("application is in queu");
    }
 
}
