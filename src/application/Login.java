package application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
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

		gridPane.setHgap(10);
		gridPane.setVgap(10);

		gridPane.setPadding(new Insets(10, 10, 10, 10));

		gridPane.add(new Label("Email: "), 1, 2);
		gridPane.add(emailTxt, 2, 2);

		gridPane.add(new Label("Password: "), 1, 3);
		gridPane.add(passwordTxt, 2, 3);

		Button logInButton = new Button("Login");

		gridPane.add(logInButton, 1,4);

		logInButton.setOnAction(e -> {
			//loginUser();
		});

		Image image = new Image("testing.jpg");
		gridPane.getChildren().add(new ImageView(image));

		Scene scene = new Scene(gridPane);
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