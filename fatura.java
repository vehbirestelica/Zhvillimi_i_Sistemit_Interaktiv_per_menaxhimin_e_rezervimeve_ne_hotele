package p;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.stage.Stage;
import p.Reservation.DbConnection;
import javafx.geometry.HPos;
import javafx.scene.image.ImageView;

public class Fatura extends Application{
	
	private static TextField cardNum=new TextField();
	private static TextField cardName=new TextField();
	private static TextField ExpDate=new TextField();
	private static TextField SecurityCode=new TextField();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
	GridPane gridPane=new GridPane();
	gridPane.setHgap(6);
	gridPane.setVgap(6);
	gridPane.setPadding(new Insets(10,10,10,10));
		gridPane.add(cardNum, 1, 0);
		gridPane.add(new Label("Numri i karteles"), 0, 0);
		cardNum.setPromptText("1234 5678 9012 3456");
		gridPane.add(new Label("Emri i karteles"), 0,1);
		gridPane.add(cardName, 1, 1);
		cardName.setPromptText("Ex. Vehbi Restelica");
		gridPane.add(ExpDate, 1,2);
		gridPane.add(new Label("Data e skadimit"), 0,2);
		ExpDate.setPromptText("01/20");
		gridPane.add(SecurityCode, 1,3);
		gridPane.add(new Label("Kodi i sigurimit"), 0,3);
		SecurityCode.setPromptText("•••");
		Button Paguaj=new Button("Paguaj");
		gridPane.add(Paguaj, 1, 4);
		gridPane.setHalignment(Paguaj, HPos.RIGHT);
		ImageView image=new ImageView("payment.png");
		gridPane.getChildren().add(new ImageView());
		gridPane.add(image, 0,4);
		
		Paguaj.setOnAction(e -> {
			Paguaj();
		});
	
	
	Scene scene = new Scene(gridPane,550,300);
	
	primaryStage.setTitle("Rezervimi");
	primaryStage.setScene(scene);
	primaryStage.show();
}
public static class DbConnection {
		private static Connection dbconnection;


			public static Connection getConnection() {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					dbconnection = DriverManager.getConnection("jdbc:mysql://localhost/projektiknk", "root", "");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
				return dbconnection ;
	}
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	private static void Paguaj() {
		String query = "INSERT INTO fatura(cardNum, cardName, ExpDate, SecurityCode) Values(?,?,?,?)";
		try {
					PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query);
					
					preparedStatement.setString(1, cardNum.getText());
					preparedStatement.setString(2, cardName.getText());
					preparedStatement.setString(3, ExpDate.getText());
					preparedStatement.setString(4, SecurityCode.getText());
//					preparedStatement.setString(4, ((TextField)dataHyrjes.getEditor()).getText());
					
			
					
					if(preparedStatement.executeUpdate() > 0) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Pagesa e fatures");
						alert.setHeaderText(null);
						alert.setContentText("Keni paguar me sukses.");
						alert.showAndWait();
					    cardNum.clear();
						cardName.clear();
						ExpDate.clear();
						SecurityCode.clear();
//						dataDaljes.clear();
						
					
					} else {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Pagesa e fatures");
						alert.setHeaderText(null);
						alert.setContentText("Keni paguar me sukses. !");
						alert.showAndWait();				
					}
					
					
				} catch(SQLException ex) {
					ex.printStackTrace();
				}
		}
}
