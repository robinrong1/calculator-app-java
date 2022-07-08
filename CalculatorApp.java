package calculatorApp;

/*
 * Program name: Calculator App
 * This program uses java GUI to simulate a virtual calculator that the user can click on and perform calculations on
 * The program utilizes multiple classes including digitbuttons, operatorbuttons, and clearbutton
 * Since a GUI window is being used here, the user can exit the program by simply closing the window
 * One flaw this program has is that it cannot handle consecutive calculations more than once (if you enter 1 + 2 + 3, it will only calculate 2 + 3)
 * Author: Robin Rong
 * Date: April 11th
 */


import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;  


public class CalculatorApp extends Frame  
{  //this class is the main class that is responsible for initializing the calculator and combining all the other 3 classes together to form a properly functioning calculator app

	public boolean clear=true;  
	double number; 
	char operator;  

	String digitButtonText[] = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", "." }; 
	//String array for digit buttons
	String operatorButtonText[] = {"sqrt", "*", "-", "+","/", "=" };  
	//string array for operator buttons

	String clearButtonText[] = {"CLEAR"}; 
	//string array for the clear button

	DigitButtons digitButton[]=new DigitButtons[11];  
	OperatorButtons operatorButton[]=new OperatorButtons[6];  
	ClearButton clrButton[]=new ClearButton[1];  

	Label displayLabel=new Label("0",Label.RIGHT);  
	//this label displays the number on the top, it is set to 0 initially


	final int FRAME_WIDTH=325,FRAME_HEIGHT=325;  
	final int HEIGHT=30, WIDTH=30, H_SPACE=10,V_SPACE=10;  
	final int TOPX=30, TOPY=50;  
	//set the dimensions for the window

	CalculatorApp(String frameText)//constructor  
	{  
		super(frameText);  

		int tempX=TOPX, y=TOPY;  
		displayLabel.setBounds(tempX,y,240,HEIGHT);  
		add(displayLabel);  

		//set Co-ordinates for Clear Button 
		tempX=TOPX+1*(WIDTH+H_SPACE); y=TOPY+1*(HEIGHT+V_SPACE);
		tempX=TOPX+1*(WIDTH+H_SPACE); y=TOPY+1*(HEIGHT+V_SPACE);  
		clrButton[0]=new ClearButton(tempX,y,WIDTH*2,HEIGHT,clearButtonText[0], this);  

		//set Co-ordinates for Digit Buttons  
		int digitX=TOPX+WIDTH+H_SPACE;  
		int digitY=TOPY+2*(HEIGHT+V_SPACE);  
		tempX=digitX;  y=digitY;  
		for(int i=0;i<digitButton.length;i++)  
		{  //for loop to iterate through each digit button
			digitButton[i]=new DigitButtons(tempX,y,WIDTH,HEIGHT,digitButtonText[i], this);  

			tempX+=WIDTH+H_SPACE;  
			if((i+1)%3==0){
				tempX=digitX; y+=HEIGHT+V_SPACE;
			}  
		}  

		//set Co-ordinates for Operator Buttons  
		int opsX=digitX+2*(WIDTH+H_SPACE)+H_SPACE;  
		int opsY=digitY;  
		tempX=opsX;  y=opsY;  
		for(int i=0;i<operatorButton.length;i++)  
		{  //for loop to iterate through each opeartor button
			tempX+=WIDTH+H_SPACE;  
			operatorButton[i]=new OperatorButtons(tempX,y,WIDTH,HEIGHT,operatorButtonText[i], this);  

			if((i+1)%2==0){
				tempX=opsX; y+=HEIGHT+V_SPACE;
			}  
		}  

		addWindowListener(new WindowAdapter()  
		{  
			public void windowClosing(WindowEvent ev)  
			{//if the window is closed, print the goodBye message and terminate the program
				goodBye();

			}  
		});  
		setLayout(null);  
		setSize(FRAME_WIDTH,FRAME_HEIGHT);  
		setVisible(true);
	}  


	static void programDescription() {
		//prints program description
		JOptionPane.showMessageDialog(null, "This program simulates an elementary calculator that user can perform simple, non-scientific calculations on\n(no trig functions, etc)\nYou can exit the program by simply closing the window\nOne flaw this program has is that it cannot handle consecutive calculations more than once (if you enter 1 + 2 + 3, it will only calculate 2 + 3)", "Program Description",  
				JOptionPane.INFORMATION_MESSAGE);
	}

	static String getFormattedText(double temp)  
	{  //method for formatting the text

		String resText=""+temp;  
		if(resText.lastIndexOf(".0")>0) { 
			resText=resText.substring(0,resText.length()-2);  
		}
		return resText; 
	}  
	
	static void goodBye() {
		//used when cancel button is clicked, prints goodbye message and exits the program
		JOptionPane.showMessageDialog(null, "Exiting program...\nGoodbye!","PROGRAM TERMINATION",   
				JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
	
	public static void main(String []args)  
	{  
		programDescription();
		new CalculatorApp("Robin's calculator assignment");  
		//call the constructor and name the GUI window robin's calculator assignment
	}  
}  