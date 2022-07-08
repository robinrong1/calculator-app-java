package calculatorApp;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ClearButton extends Button implements ActionListener  
{  //this class is responsible for the clear button and its actions
	CalculatorApp calculator;  

	ClearButton(int x,int y, int width,int height,String cap, CalculatorApp calculator)  
	{  
		super(cap);  
		setBounds(x,y,width,height);  
		this.calculator=calculator;  
		this.calculator.add(this);  
		addActionListener(this);  
	}  
 
	public void actionPerformed(ActionEvent ev)  
	{  //when clear button is clicked
		
		calculator.displayLabel.setText("0");calculator.clear=true;  
		//clear the calculator
	} 
}