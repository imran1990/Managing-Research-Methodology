/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package research.registration.system;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author shuvo
 */
public class ApplicationSubmittedFacultyController implements Initializable {
    
    
   private final String DB_USERNAME = "imran";
   private final String DB_PASSWORD = "12345";
   private final String DB_HOSTNAME = "localhost";
   private final String DB_DBNAME = "research";
   private final String DB_URL = "jdbc:mysql://"+DB_HOSTNAME+"/"+DB_DBNAME;

    @FXML
    private TableView<Registration> TableView;
    
    private ObservableList<Registration> resultList;
    @FXML
    private TableColumn<Registration, String> FacultyInitial;
    @FXML
    private TableColumn<Registration, String> TopicName;
    @FXML
    private TableColumn<Registration, Number> Student1;
    @FXML
    private TableColumn<Registration, Number>Student2;
    @FXML
    private TableColumn<Registration, Number> Student3;
    @FXML
    private TextField initialField;
    @FXML
    private TextField idFIeld;
    @FXML
    private Label notification;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SeeApplicationButton(ActionEvent event) {
           
           String Ti= initialField.getText();
           
          ArrayList<Registration>appList = new ArrayList<>();
            try{
                com.mysql.jdbc.Connection connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                com.mysql.jdbc.Statement statement = (com.mysql.jdbc.Statement) connection.createStatement();
                String query = "select * from registration where initial = '"+Ti+"' and status = '"+"null"+"';";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                   String initial = resultSet.getString("initial");
                    String topic = resultSet.getString("topicname");
                    Integer s1 = resultSet.getInt("id1");
                    Integer s2 = resultSet.getInt("id2");
                    Integer s3 = resultSet.getInt("id3");
                    Registration t = new Registration(initial,topic,s1, s2, s3);
                    appList.add(t);
                    }
                }catch(SQLException sqle){
                System.err.println("sqle");}
        
       resultList = FXCollections.observableArrayList();
       resultList.addAll(appList);
       TableView.setItems(resultList);
       FacultyInitial.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSupervisorinitial()));
       TopicName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTopicname()));
       Student1.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId1()));
       Student2.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId2()));
       Student3.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId3()));
    }

    @FXML
    private void ApproveButtonAction(ActionEvent event) {
       
                   Integer id = Integer.parseInt(idFIeld.getText());
        String query = "update registration set status ='"+"ok"+"' where id1 = "+id+";";
        try{
            Connection connection = DriverManager.getConnection 
                     (DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);}
        catch(SQLException sqle){
            System.err.println(sqle);
         } 
         
                             
        String Ti= initialField.getText();
           
          ArrayList<Registration>appList = new ArrayList<>();
            try{
                com.mysql.jdbc.Connection connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                com.mysql.jdbc.Statement statement = (com.mysql.jdbc.Statement) connection.createStatement();
                String query1 = "select * from registration where initial = '"+Ti+"' and status = '"+"null"+"';";
                ResultSet resultSet = statement.executeQuery(query1);
                while (resultSet.next()){
                   String initial = resultSet.getString("initial");
                    String topic = resultSet.getString("topicname");
                    Integer s1 = resultSet.getInt("id1");
                    Integer s2 = resultSet.getInt("id2");
                    Integer s3 = resultSet.getInt("id3");
                    Registration t = new Registration(initial,topic,s1, s2, s3);
                    appList.add(t);
                    }
                }catch(SQLException sqle){
                System.err.println("sqle");}
        
       resultList = FXCollections.observableArrayList();
       resultList.addAll(appList);
       TableView.setItems(resultList);
       FacultyInitial.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSupervisorinitial()));
       TopicName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTopicname()));
       Student1.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId1()));
       Student2.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId2()));
       Student3.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId3()));
       
       notification.setText("Application is Successfully approved");
    }

    @FXML
    private void RejectButtonAction(ActionEvent event) {
                 Integer id = Integer.parseInt(idFIeld.getText());
        String query = "update registration set status ='"+"not"+"' where id1 = "+id+";";
        try{
            Connection connection = DriverManager.getConnection 
                     (DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);}
        catch(SQLException sqle){
            System.err.println(sqle);
         } 
         
                             
        String Ti= initialField.getText();
           
          ArrayList<Registration>appList = new ArrayList<>();
            try{
                com.mysql.jdbc.Connection connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                com.mysql.jdbc.Statement statement = (com.mysql.jdbc.Statement) connection.createStatement();
                String query1 = "select * from registration where initial = '"+Ti+"' and status = '"+"null"+"';";
                ResultSet resultSet = statement.executeQuery(query1);
                while (resultSet.next()){
                   String initial = resultSet.getString("initial");
                    String topic = resultSet.getString("topicname");
                    Integer s1 = resultSet.getInt("id1");
                    Integer s2 = resultSet.getInt("id2");
                    Integer s3 = resultSet.getInt("id3");
                    Registration t = new Registration(initial,topic,s1, s2, s3);
                    appList.add(t);
                    }
                }catch(SQLException sqle){
                System.err.println("sqle");}
        
       resultList = FXCollections.observableArrayList();
       resultList.addAll(appList);
       TableView.setItems(resultList);
       FacultyInitial.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSupervisorinitial()));
       TopicName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTopicname()));
       Student1.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId1()));
       Student2.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId2()));
       Student3.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId3()));
    
    notification.setText("Application is rejected");
    }
    
}
