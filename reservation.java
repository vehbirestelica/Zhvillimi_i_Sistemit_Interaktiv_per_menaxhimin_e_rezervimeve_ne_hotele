package p;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Reservation extends Application{	
	
	
	private static TextField emritxt=new TextField();
	private static TextField mbiemritxt=new TextField();
	private static TextField emailtxt=new TextField();
	private static DatePicker dataHyrjes = new DatePicker();
	private static DatePicker dataDaljes = new DatePicker();
	private static TextField telnum = new TextField();
	private static ComboBox<String> Shtetijuaj=new ComboBox<String>();

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane gridPane=new GridPane();
		gridPane.setHgap(20);
		gridPane.setVgap(20);
		gridPane.setPadding(new Insets(10,10,10,10));
		gridPane.add(new Label("Emri "), 0, 0);
		gridPane.add(emritxt, 1, 0);
		gridPane.add(new Label("Mbiemri "), 0, 1);
		gridPane.add(mbiemritxt, 1, 1);
		gridPane.add(new Label("Email "), 0, 2);
		gridPane.add(emailtxt, 1,2);
		gridPane.add(new Label("Data e hyrjes"), 3, 0);
		gridPane.add(dataHyrjes, 3, 1);
		gridPane.add(new Label("Data e daljes"), 3, 2);
		gridPane.add(dataDaljes, 3, 3);
		gridPane.add(new Label("Tel."), 0, 3);
		gridPane.add(telnum, 1,3);
		
		
		//ComboBox<String> Shtetijuaj = new ComboBox<String>();
		Shtetijuaj.getItems().addAll("Austria","Albania", "Belgium", "Denmark","France", "Germany","Italy" ,"Kosovo",
				"Netherlands", "Portugal", "Spain", "Sweden");
		gridPane.add(new Label("Shteti juaj :"), 0, 4);
		gridPane.add(Shtetijuaj, 1, 4);
		
		RadioButton allInclusive=new RadioButton("All Inclusive");
		RadioButton economic=new RadioButton("Economic");
		gridPane.add(allInclusive, 3,4);
		gridPane.add(economic, 3,5);
		
		Button rezervoButton=new Button("Rezervo");
		
		gridPane.add(rezervoButton, 4, 7);
		
		rezervoButton.setOnAction(e -> {
			rezervoUser();
		});
		
		Scene scene = new Scene(gridPane,680,500);
		
		primaryStage.setTitle("Rezervimi");
		primaryStage.setScene(scene);
		primaryStage.show();


	}
	public static class DbConnection {
		private static Connection dbconnection;


			public static Connection getConnection() {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					dbconnection = DriverManager.getConnection("jdbc:mysql://localhost/projektiknk", "root", "123456");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
				return dbconnection ;
	}
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
	private static void rezervoUser() {
		String query = "INSERT INTO rezervimet(emri ,mbiemri , email,tel,shteti,datahyrjes,datadaljes) Values(?,?,?,?,?,?,?)";
		try {
					PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query);
					
					preparedStatement.setString(1, emritxt.getText());
					preparedStatement.setString(2, mbiemritxt.getText());
					preparedStatement.setString(3, emailtxt.getText());
					preparedStatement.setString(4, ((TextField)dataHyrjes.getEditor()).getText());
					preparedStatement.setString(5, ((TextField)dataDaljes.getEditor()).getText());
					preparedStatement.setString(6, telnum.getText());
					preparedStatement.setString(7, ((TextField)Shtetijuaj.getEditor()).getText());     
					
					if(preparedStatement.executeUpdate() > 0) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Rezervimi i Hotelit");
						alert.setHeaderText(null);
						alert.setContentText("Keni rezervuar me sukses. Ju mirepresim !");
						alert.showAndWait();
					    emritxt.clear();
						mbiemritxt.clear();
						emailtxt.clear();
//						dataHyrjes.clear();
//						dataDaljes.clear();
						
					
					} else {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Rezervimi i Hotelit");
						alert.setHeaderText(null);
						alert.setContentText("Keni rezervuar me sukses. Ju mirepresim !");
						alert.showAndWait();				
					}
					
					
				} catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
}
