package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import Application.Calculator;;


public class MainController {
	
	 
	@FXML TextArea textAreaEquation;
	@FXML Label lblResult;
	
	
//	Adding text to gui
	public void addDot() {
		textAreaEquation.appendText(".");
	}
	
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
	
//	Clearing gui text
	public void clear() {
		textAreaEquation.clear();
	}
	
//	Getting result of the giveng equation
	public void result() {
		Calculator calc = new Calculator();
		try {
			if (textAreaEquation.getText().matches("[a-ö].+||[A-Ö.+]") && !textAreaEquation.getText().matches("[0-9]")) {
				textAreaEquation.setText("You cannot have letters in the equation.");

			} else{
				lblResult.setText("Result: " + calc.calculateExpression(textAreaEquation.getText()));	
			}
		} catch (ArithmeticException e) {
			textAreaEquation.setText("You cannot divide by zero");
		} catch (NumberFormatException e) {
			textAreaEquation.setText("You have typed a not allowed sign or a double sign.");
		}
	}
	
	
	
	
	
	
}
