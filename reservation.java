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
import javafx.stage.Stage;

public class Reservation extends Application{	
	
	
	private static TextField emritxt=new TextField();
	private static TextField mbiemritxt=new TextField();
	private static TextField emailtxt=new TextField();
	private static DatePicker dataHyrjes = new DatePicker();
	private static DatePicker dataDaljes = new DatePicker();
	private static TextField telnum = new TextField();
	private static RadioButton dhoma = new RadioButton();
	private static ComboBox<String> Shtetijuaj=new ComboBox<String>();
	private static TextField cardNum=new TextField();
	private static TextField cardName=new TextField();
	private static TextField ExpDate=new TextField();
	private static TextField SecurityCode=new TextField();

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane gridPane=new GridPane();
		gridPane.setHgap(20);
		gridPane.setVgap(20);
		gridPane.setPadding(new Insets(10,10,10,10));
		gridPane.add(new Label("Emri :"), 0, 0);
		gridPane.add(emritxt, 1, 0);
		gridPane.add(new Label("Mbiemri :"), 0, 1);
		gridPane.add(mbiemritxt, 1, 1);
		gridPane.add(new Label("Email :"), 0, 2);
		gridPane.add(emailtxt, 1,2);
		gridPane.add(new Label("Data e hyrjes"), 3, 0);
		gridPane.add(dataHyrjes, 3, 1);
		gridPane.add(new Label("Data e daljes"), 3, 2);
		gridPane.add(dataDaljes, 3, 3);
		gridPane.add(new Label("Tel."), 0, 3);
		gridPane.add(telnum, 1,3);
		gridPane.add(new Label("Dhoma : "), 0, 5);
		
		Label sherbimetShtese=new Label("Sherbimet Shtese: ");
		gridPane.setHalignment(sherbimetShtese, HPos.RIGHT);
		gridPane.add(sherbimetShtese, 3, 5);
		CheckBox TV = new CheckBox("TV");
		gridPane.add(TV, 4, 4);
		CheckBox WIFI = new CheckBox("WIFI");
		gridPane.add(WIFI, 4, 5);
		CheckBox PS5 = new CheckBox("PS4");
		gridPane.add(PS5, 4, 6);
		
		emritxt.setPromptText("Emri...");
		mbiemritxt.setPromptText("Mbiemri...");
		emailtxt.setPromptText("name@company.com");
		dataHyrjes.setPromptText("mm/dd/yyyy");
		dataDaljes.setPromptText("mm/dd/yyyy");
		telnum.setPromptText("04x/xxx-xxx");
		
		RadioButton single=new RadioButton("Single");
		RadioButton couple=new RadioButton("Couple");
		RadioButton threeto5=new RadioButton("3-5");
		RadioButton up5=new RadioButton("+5");
		gridPane.add(single, 1,5);
		gridPane.add(couple, 1,6);
		gridPane.add(threeto5, 1,7);
		gridPane.add(up5, 1,8);
		
		//ComboBox<String> Shtetijuaj = new ComboBox<String>();
		Shtetijuaj.getItems().addAll("Austria","Albania", "Belgium", "Denmark","France", "Germany","Italy" ,"Kosovo",
				"Netherlands", "Portugal", "Spain", "Sweden");
		gridPane.add(new Label("Shteti juaj :"), 0, 4);
		gridPane.add(Shtetijuaj, 1, 4);
		Shtetijuaj.getSelectionModel().select("Kosovo");
		
//		Label standarti=new Label("Standarti");
//		gridPane.setValignment(standarti, VPos.BASELINE);
//		gridPane.add(standarti, 4, 0);
		RadioButton seaView=new RadioButton("Sea View");
		RadioButton allInclusive=new RadioButton("All Inclusive");
		RadioButton economic=new RadioButton("Economic");
		gridPane.add(seaView, 4, 0);
		gridPane.add(allInclusive, 4, 1);
		gridPane.add(economic, 4, 2);
		Button vazhdo=new Button("Vazhdo...");
		gridPane.add(vazhdo, 0, 10);
		vazhdo.setOnAction(e -> {
			gridPane.add(cardNum, 1, 11);
			gridPane.add(new Label("Numri i karteles"), 0, 11);
			cardNum.setPromptText("1234 5678 9012 3456");
			gridPane.add(new Label("Emri i karteles"), 0, 12);
			gridPane.add(cardName, 1, 12);
			cardName.setPromptText("Ex. Vehbi Restelica");
			gridPane.add(ExpDate, 1, 13);
			gridPane.add(new Label("Data e skadimit"), 0, 13);
			ExpDate.setPromptText("01/20");
			gridPane.add(SecurityCode, 1, 14);
			gridPane.add(new Label("Kodi i sigurimit"), 0, 14);
			SecurityCode.setPromptText("•••");
			Button Paguaj=new Button("Paguaj");
			gridPane.add(Paguaj, 1, 15);
			gridPane.setHalignment(Paguaj, HPos.RIGHT);
			final ImageView imv = new ImageView();
			final Image image2 = new Image(Main.class.getResourceAsStream("payment.png"));
			imv.setImage(image2);
			final HBox pictureRegion = new HBox();
			pictureRegion.getChildren().add(imv);
			gridPane.add(pictureRegion, 1, 16);
//			Label NrKarteles=new Label("Numri i karteles :");
//			gridPane.add(NrKarteles, 1, 10);
//			Label EmriKarteles=new Label("Emri i karteles :");
//			gridPane.add(EmriKarteles, 1, 11);
//			Label ExpDate=new Label("Exp. Date");
//			gridPane.add(ExpDate, 1, 12);
//			Label secCode=new Label("Security Code");
//			gridPane.add(secCode, 2, 12);
		});
		
//		Label Pagesa = new Label("Metoda e Pageses :");
//		RadioButton paypal=new RadioButton("PayPal");
//		RadioButton creditCart=new RadioButton("Kredit Karte");
//		gridPane.add(Pagesa,1,9);
//		gridPane.add(paypal, 2, 9);
//		gridPane.add(creditCart, 3, 9);
//		gridPane.setHalignment(paypal, HPos.CENTER);
//		
//		Image image=new Image("File:paypal.png");
//		gridPane.getChildren().add(new ImageView(image));
		
		Button rezervoButton=new Button("Rezervo");
		gridPane.add(rezervoButton, 4, 7);
		
		rezervoButton.setOnAction(e -> {
			rezervoUser();
		});
		
		Scene scene = new Scene(gridPane,1000,800);
		
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
