/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package research.registration.system;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shuvo
 */
public class ApplyFormController implements Initializable {
    
   private final String DB_USERNAME = "imran";
   private final String DB_PASSWORD = "12345";
   private final String DB_HOSTNAME = "localhost";
   private final String DB_DBNAME = "research";
   private final String DB_URL = "jdbc:mysql://"+DB_HOSTNAME+"/"+DB_DBNAME;

    private TextField CourseDisplayfield;
    @FXML
    private TextField ResearchTopicDisplayfield;
    @FXML
    private AnchorPane comboxid;
    @FXML
    private TextField StudentId1Displayfield;
    @FXML
    private TextField StudentId2Displayfield;
    @FXML
    private TextField StudentId3Displayfield;
    @FXML
    private TextField SupervisorDisplayField;
    @FXML
    private TableView<Registration> TableView;
    private ObservableList<Registration> resultList;
    @FXML
    private TableColumn<Registration, String> FacultyInitial;
    @FXML
    private TableColumn<Registration, String> Topicname;
    @FXML
    private TableColumn<Registration, Number> Student1;
    @FXML
    private TableColumn<Registration, Number> Student2;
    @FXML
    private TableColumn<Registration, Number> Student3;
   
    
    
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     private void insertRegistrationRecord(Registration registration){
        
        String initial= registration.getSupervisorinitial();
        String topicname = registration.getTopicname();
        int id1   = registration.getId1();
        int id2   = registration.getId2();
        int id3   = registration.getId3();
        String status = registration.getStatus();
        String cmsg = registration.getCmsg();
        
        
        String query = "insert into registration values('"+initial+"','"+topicname+"',"+id1+","+id2+","+id3+",'"+status+"','"+cmsg+"');";
        try{
            Connection connection = DriverManager.getConnection 
                     (DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);}
        catch(SQLException sqle){
            System.err.println(sqle);
        }
    }

    @FXML
    private void ApplyhandleButtonaction(ActionEvent event) {
        
        String supervisor_initial=SupervisorDisplayField.getText();
        String topicname=ResearchTopicDisplayfield.getText();
        int studentId1= Integer.parseInt(StudentId1Displayfield.getText());
        int studentId2 =Integer.parseInt(StudentId2Displayfield.getText());
        int studentId =Integer.parseInt(StudentId3Displayfield.getText());
        
        
        
        
        
        Registration registration  = new Registration(supervisor_initial,topicname,studentId1,studentId2,studentId);
        insertRegistrationRecord(registration);
        
        ArrayList<Registration>appList = new ArrayList<>();
            try{
                com.mysql.jdbc.Connection connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                com.mysql.jdbc.Statement statement = (com.mysql.jdbc.Statement) connection.createStatement();
                String query = "select * from registration;";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                   String initial = resultSet.getString("initial");
                    String topic = resultSet.getString("topicname");
                    Integer s1 = resultSet.getInt("id1");
                    Integer s2 = resultSet.getInt("id2");
                    Integer s3 = resultSet.getInt("id3");
                    String sta = "null";
                    String msg = "null";
                    Registration t = new Registration(initial,topic,s1, s2, s3, sta, msg);
                    appList.add(t);
                    }
                }catch(SQLException sqle){
                System.err.println("sqle");}
        
       resultList = FXCollections.observableArrayList();
       resultList.addAll(appList);
       TableView.setItems(resultList);
       FacultyInitial.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSupervisorinitial()));
       Topicname.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTopicname()));
       Student1.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId1()));
       Student2.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId2()));
       Student3.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId3()));
    }
    

    @FXML
    private void LogoutHandleButton(ActionEvent event)throws IOException {
        
         Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene= new Scene(root);
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
}
