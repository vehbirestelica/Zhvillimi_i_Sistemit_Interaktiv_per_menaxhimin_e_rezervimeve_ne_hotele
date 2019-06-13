package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
  

public class exp extends Application {
	
 String user = "JavaFX2";
 String pw = "password";
 String checkUser, checkPw;
  
    public static void main(String[] args) {
        launch(args);
    }
      
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Please Login");
        //progres bar
        
       
       
 
 
        
      
        
         //vBox toolbar
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10,0,0,0));

        Button btnNew = new Button("New");
        Button btnPause = new Button("Home");
        Button btnQuit = new Button("Main");
        CheckBox chkSound = new CheckBox("Item");
        CheckBox chkMusic = new CheckBox("Item1");
        RadioButton rdoEasy = new RadioButton("Select");
        RadioButton rdoMedium = new RadioButton("Select1");
        RadioButton rdoHard = new RadioButton("Select2");
        ToggleGroup groupDifficulty = new ToggleGroup();
        groupDifficulty.getToggles().addAll(
                rdoEasy,
                rdoMedium,
                rdoHard
            );
        ToolBar toolBar1 = new ToolBar();
        toolBar1.getItems().addAll(
                new Separator(),
                btnNew,
                btnPause,
                btnQuit,
                new Separator(),
                chkSound,
                chkMusic,
                new Separator()
            );
        ToolBar toolBar2 = new ToolBar();
        toolBar2.setOrientation(Orientation.VERTICAL);
        toolBar2.getItems().addAll(
                new Separator(),
                rdoEasy,
                rdoMedium,
                rdoHard,
                new Separator()
            );
        pane.setTop(toolBar1);
        pane.setLeft(toolBar2);
        toolBar1.setOrientation(Orientation.HORIZONTAL);
        toolBar2.setOrientation(Orientation.HORIZONTAL);

       
        
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10,50,50,50));
        
       
        //creates menu bar 
        BorderPane layout= new BorderPane();
        layout.setPadding(new Insets(-10,10,10,0));
        MenuBar menubar= new MenuBar();


        //Menu name
        Menu filemenu= new Menu ("File");


        //Create and add menu items to menu
        MenuItem newproject= new MenuItem("New Project...");
        filemenu.getItems().add(newproject);

        MenuItem newfile= new MenuItem("New File...");
        filemenu.getItems().add(newfile);
        filemenu.getItems().add(new SeparatorMenuItem());

        MenuItem openproject= new MenuItem("Open Project...");
        filemenu.getItems().add(openproject);

        MenuItem openfile= new MenuItem("Open File...");
        filemenu.getItems().add(openfile);
        filemenu.getItems().add(new SeparatorMenuItem());

        MenuItem save= new MenuItem("Save");
        filemenu.getItems().add(save);

        MenuItem saveas= new MenuItem("Save As...");
        filemenu.getItems().add(saveas);

        MenuItem saveall= new MenuItem("Save All");
        filemenu.getItems().add(saveall);
        filemenu.getItems().add(new SeparatorMenuItem());

        MenuItem exit= new MenuItem("Exit");
        filemenu.getItems().add(exit);

        //Creates another menu named editmenu
        Menu editmenu= new Menu("Edit");

        MenuItem cut= new MenuItem("Cut");
        editmenu.getItems().add(cut);

        MenuItem copy= new MenuItem("Copy");
        editmenu.getItems().add(copy);

        MenuItem paste= new MenuItem("Paste");
        editmenu.getItems().add(paste);

        //add menus to menu bar
        menubar.getMenus().addAll(filemenu, editmenu);
        layout.setTop(menubar);

       

                
       
        
        //Adding HBox
        HBox hb = new HBox();
        hb.setPadding(new Insets(20,20,20,30));
         
        //Adding GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
         
       //Implementing Nodes for GridPane
        Label lblUserName = new Label("Username");
        final TextField txtUserName = new TextField();
        Label lblPassword = new Label("Password");
        final PasswordField pf = new PasswordField();
        Button btnLogin = new Button("Login");
        final Label lblMessage = new Label();
         
        //Adding Nodes to GridPane layout
        gridPane.add(lblUserName, 0, 0);
        gridPane.add(txtUserName, 1, 0);
        gridPane.add(lblPassword, 0, 1);
        gridPane.add(pf, 1, 1);
        gridPane.add(btnLogin, 2, 1);
        gridPane.add(lblMessage, 1, 2);
         
                 
        //Reflection for gridPane
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        gridPane.setEffect(r);
         
        //DropShadow effect 
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
         
        //Adding text and DropShadow effect to it
        Text text = new Text("JavaFX 2 Login");
        text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
        text.setEffect(dropShadow);
         
        //Adding text to HBox
        hb.getChildren().add(text);
                           
        //Add ID's to Nodes
        bp.setId("bp");
        gridPane.setId("root");
        btnLogin.setId("btnLogin");
        text.setId("text");
                 
        //Action for btnLogin
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(lblUserName.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your name");
                    return;
                }
                if(lblPassword.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your email id");
                    return;
                }
               
                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Welcome " + lblUserName.getText());
            }

			private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
				// TODO Auto-generated method stub
				 Alert alert = new Alert(alertType);
		            alert.setTitle(title);
		            alert.setHeaderText(null);
		            alert.setContentText(message);
		            alert.initOwner(owner);
		            alert.show();
			}
        });

    
        
        //Add HBox and GridPane layout to BorderPane Layout
        bp.setTop(layout);
        bp.setCenter(gridPane);  
        bp.setLeft(hb);
        bp.setBottom(pane);
      
         
        //Adding BorderPane to the scene and loading CSS
     Scene scene = new Scene(bp);



     scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
     primaryStage.setScene(scene);
       primaryStage.titleProperty().bind(
                 scene.widthProperty().asString().
                 concat(" : ").
                 concat(scene.heightProperty().asString()));
     //primaryStage.setResizable(false);
     primaryStage.show();
    }
}