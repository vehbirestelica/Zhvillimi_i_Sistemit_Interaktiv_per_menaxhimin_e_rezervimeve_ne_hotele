package Employer;

import java.sql.*;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//import main.Employer;

public class Main extends Application {

	
	private TextField idTxt = new TextField();
	private TextField name1Txt = new TextField();
	private TextField lastname1Txt = new TextField();
	private TextField roomnoTxt = new TextField();
	

	private Button insertBtn = new Button("Insert");
	private Button updateBtn = new Button("Update");
	private Button deleteBtn = new Button("Delete");
	private Button clearBtn = new Button("Clear");
	
	
	
	
	private TableView EmployersTable = new TableView();
	
	
	public void start(Stage primaryStage) {
		
		insertBtn.setStyle("-fx-background-color: #ECEFF1;-fx-font-size: 15;-fx-text-fill:#4DD0E1");
		updateBtn.setStyle("-fx-background-color: #ECEFF1;-fx-font-size: 15;-fx-text-fill:#4DD0E1");
		deleteBtn.setStyle("-fx-background-color: #ECEFF1;-fx-font-size: 15;-fx-text-fill:#4DD0E1");
		clearBtn.setStyle("-fx-background-color: #ECEFF1;-fx-font-size: 15;-fx-text-fill:#4DD0E1");
		
		// Form pane
		GridPane formPane = new GridPane();
		
		formPane.addRow(0, new Label("ID: "), idTxt);
		formPane.addRow(1, new Label("name1: "), name1Txt);
		formPane.addRow(2, new Label("Last name1: "), lastname1Txt);
		formPane.addRow(3, new Label("Room Number: "), roomnoTxt);
		
		formPane.setHgap(10);
		formPane.setVgap(10);
		
		idTxt.setDisable(true);
		
		// Buttons pane
		HBox buttonsPane = new HBox(10);
		
		buttonsPane.getChildren().addAll(insertBtn, updateBtn, deleteBtn, clearBtn);
		
		insertBtn.setOnAction(e -> {
			insertEmployer();
		});
		
		clearBtn.setOnAction(e -> {
			clearForm();
		});
		
		deleteBtn.setOnAction( e -> {
			deleteEmployer();
		});
		
		updateBtn.setOnAction( e -> {
			updateEmployer();
		});
		
		// Left Pane
		
		VBox leftPane = new VBox(15);
		
		leftPane.getChildren().addAll(formPane, buttonsPane);
		
		
		// Employers table
		TableColumn<String, Employer> column1 = new TableColumn<>("ID");
		column1.setCellValueFactory(new PropertyValueFactory("id"));
		column1.setPrefWidth(60);
		
		TableColumn<String, Employer> column2 = new TableColumn<>("Name");
		column2.setCellValueFactory(new PropertyValueFactory("name1"));
		column2.setPrefWidth(150);
		
		TableColumn<String, Employer> column3 = new TableColumn<>("Last Name");
		column3.setCellValueFactory(new PropertyValueFactory("lastname1"));
		column3.setPrefWidth(150);
		
		TableColumn<String, Employer> column4 = new TableColumn<>("Room Number");
		column4.setCellValueFactory(new PropertyValueFactory("roomno"));
		column4.setPrefWidth(120);
		
		
		EmployersTable.setRowFactory(tv -> {
            TableRow<Employer> row = new TableRow<>();
            
            row.setOnMouseClicked(event -> {
               idTxt.setText( String.valueOf(row.getItem().getId()));
               name1Txt.setText(row.getItem().getname1());
               lastname1Txt.setText(row.getItem().getlastname1());
               roomnoTxt.setText( String.valueOf(row.getItem().getroomno()));
              
            });
            
            return row ;
        });

	EmployersTable.getColumns().add(column1);
		EmployersTable.getColumns().add(column2);
		EmployersTable.getColumns().add(column3);
		EmployersTable.getColumns().add(column4);
		EmployersTable.setStyle(" -fx-background-color: aqua");

		
		EmployersTable.setPrefWidth(650);
		EmployersTable.setPrefHeight(200);
		// Main Pane
	HBox mainPane = new HBox(10);
		mainPane.setStyle("-fx-background-color: lightblue");

		mainPane.getChildren().addAll(leftPane, EmployersTable);
		
		mainPane.setPadding(new Insets(15, 15, 15 ,15));
		
		
		Scene scene = new Scene(mainPane, 1000, 400);
		
		primaryStage.setTitle("Library");
		primaryStage.setScene(scene);
		
		showEmployers();
		
		primaryStage.show();
	}
	

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void showEmployers() {
		List<Employer> Employers = Employer.getEmployers();
		
		ObservableList<Employer> EmployerList = FXCollections.observableArrayList();
		
		for(int i = 0; i < Employers.size(); i++) {
			EmployerList.add(Employers.get(i));
		}
		
		EmployersTable.setItems(EmployerList);
	}
	
	public void insertEmployer() {
		
		if(Employer.addEmployer(name1Txt.getText(), lastname1Txt.getText(), Integer.parseInt(roomnoTxt.getText()))) {
			showEmployers();
			clearForm();
		}
	}
	
	public void deleteEmployer() {
		if(Employer.deleteEmployer(Integer.parseInt(idTxt.getText()))) {
			showEmployers();
			clearForm();
		}
	}
	
	
	public void updateEmployer() {
		if(Employer.updateEmployer(Integer.parseInt(idTxt.getText()), name1Txt.getText(), lastname1Txt.getText(), Integer.parseInt(roomnoTxt.getText()))) {
			showEmployers();
			clearForm();
		}
	}
	
	public void clearForm() {
		idTxt.setText("");
		name1Txt.setText("");
		lastname1Txt.setText("");
		roomnoTxt.setText("");
	}
	
}
