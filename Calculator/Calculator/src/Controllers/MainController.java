package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import Application.Calculator;;


public class MainController {
	
	 
	@FXML TextArea textAreaEquation;
	@FXML Label lblResult;
	
	public void addZero() {
		textAreaEquation.appendText("0");
	}
	
	public void addOne() {
		textAreaEquation.appendText("1");
	}
	
	public void addTwo() {
		textAreaEquation.appendText("2");
	}
	
	public void addThree() {
		textAreaEquation.appendText("3");
	}
	
	public void addFour() {
		textAreaEquation.appendText("4");
	}
	
	public void addFive() {
		textAreaEquation.appendText("5");
	}
	
	public void addSix() {
		textAreaEquation.appendText("6");
	}
	
	public void addSeven() {
		textAreaEquation.appendText("7");
	}
	
	public void addEight() {
		textAreaEquation.appendText("8");
	}
	
	public void addNine() {
		textAreaEquation.appendText("9");
	}
	
	public void addPlus() {
		textAreaEquation.appendText("+");
	}
	
	public void addMinus() {
		textAreaEquation.appendText("-");
	}
	
	public void addDivision() {
		textAreaEquation.appendText("/");
	}
	
	public void addMulitply() {
		textAreaEquation.appendText("*");
	}
	
	public void addModulus() {
		textAreaEquation.appendText("%");
	}
	
	public void clear() {
		textAreaEquation.clear();
	}
	
	public void result() {
		Calculator calc = new Calculator();
	lblResult.setText("Result: " + calc.calculateExpression(textAreaEquation.getText()));
		
	}
	
	
	
	
	
	
}
