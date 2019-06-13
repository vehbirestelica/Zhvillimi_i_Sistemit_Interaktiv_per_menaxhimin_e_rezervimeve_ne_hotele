package application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class Login extends Application {

	private Connection dbConnection;

	private TextField emailTxt = new TextField();
	private PasswordField passwordTxt = new PasswordField();
	private Stage mainStage;


	public void start(Stage primaryStage) {
		mainStage = primaryStage;
		//setConnection();

		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER); //when resized still in the middle :)

		gridPane.setHgap(10);
		gridPane.setVgap(10);

		gridPane.setPadding(new Insets(10, 10, 10, 10));

		gridPane.add(new Label("Email: "), 1, 2);
		gridPane.add(emailTxt, 2, 2);

		gridPane.add(new Label("Password: "), 1, 3);
		gridPane.add(passwordTxt, 2, 3);

		Button logInButton = new Button("Login");
		Button SignUpButton = new Button("Signup");
		logInButton.setStyle("-fx-background-color: blue;-fx-text-fill: white;");
		SignUpButton.setStyle("-fx-background-color: blue;-fx-text-fill: white;");
		gridPane.add(logInButton, 1,4);
		gridPane.add(SignUpButton, 2,4);
		SignUpButton.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent event) {
		        Pane pane=new Pane();
		        Stage stage = new Stage();
				stage.setTitle("My New Stage Title");
				stage.setScene(new Scene(pane, 450, 450,Color.BEIGE));
				stage.show();
				primaryStage.close();
		    }
		});





//		Image image = new Image("testing.jpg");
//		ImageView imageView2 = new ImageView(image);
//		imageView2.setFitHeight(300);
//		imageView2.setFitWidth(400);
//		gridPane.getChildren().add(imageView2);

		Scene scene = new Scene(gridPane,Color.BLACK);
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(700);
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);

		primaryStage.show();





	}

	/*private void setConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/knk1", "root", "root");
		} catch (Exception ex) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Database problem");
			alert.setHeaderText(null);
			alert.setContentText("Can not connect to database");
			alert.showAndWait();
			System.exit(0);
		}
	}*/

	public static void main(String[] args) {
		Application.launch(args);
	}

	/*private void loginUser() {
		String query = "Select * from users where email = ? AND password = ?";

		try {

			PreparedStatement preparedStatement = dbConnection.prepareStatement(query);

			preparedStatement.setString(1, emailTxt.getText());
			preparedStatement.setString(2, passwordTxt.getText());

			ResultSet result = preparedStatement.executeQuery();

			if(result.next()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Login result");
				alert.setHeaderText(null);
				alert.setContentText("You are logged in!");
				alert.showAndWait();

				mainStage.hide();
				MainProgram.createMainStage();

			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Login result");
				alert.setHeaderText(null);
				alert.setContentText("Email or password is wrong!");
				alert.showAndWait();

			}

		} catch(SQLException ex) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Database problem");
			alert.setHeaderText(null);
			alert.setContentText(ex.getMessage());
			alert.showAndWait();
			System.exit(0);
		}
	}*/


}