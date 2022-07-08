package calculatorApp;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class OperatorButtons extends Button implements ActionListener  
{  //this class is responsible for the operator buttons and what happens after the user clicks on them
	CalculatorApp calculator;  

	OperatorButtons(int x,int y, int width,int height,String cap, CalculatorApp clc)  
	{  
		super(cap);  
		setBounds(x,y,width,height);  
		this.calculator=clc;  
		this.calculator.add(this);  
		addActionListener(this);  
	}  

	public void actionPerformed(ActionEvent ev)  
	{  
		String opText=((OperatorButtons)ev.getSource()).getLabel();  
		//check which button is clicked

		calculator.clear=true;  
		double temp=Double.parseDouble(calculator.displayLabel.getText()); 
		//set the variable temp to whatever number is displayed on the calculator right now

		if(opText.equals("sqrt")) 
			//if the user clicked the sqrt button, get the square root of the number
		{  
			try  
			{
				double tempd=Math.sqrt(temp); //get the square root 
				calculator.displayLabel.setText(CalculatorApp.getFormattedText(tempd));
				//format the text
			}  
			catch(ArithmeticException excp)  
			{//if an arithmetic exception occurs, catch it
				calculator.displayLabel.setText("Divide by 0.");
				return;  
			}  
		}
		if(!opText.equals("="))  
		{  //when = sign is clicked, 
			calculator.number=temp;  
			calculator.operator=opText.charAt(0);  
			return;  
		}  

		switch(calculator.operator)  
		//switch statement to see which arithmetic operator is being pressed
		{  
		case '+': //if the user clicks +, add the two numbers 
			temp+=calculator.number;
			break;  
		case '-':  //if the user clicks -, subtract temp from the displayed number
			temp=calculator.number-temp;
			break;  
		case '*':  //if the user click *, multiply the two numbers
			temp*=calculator.number;
			break;  
		case '/': //if the user click /, divide the two numbers 
			try
			{
				temp=calculator.number/temp;//divide the two numbers
			}  
			catch(ArithmeticException excp)  
			{//if an arithmetic exception occurs, that means the user tried to divide by zero, catch the exception
				calculator.displayLabel.setText("Divide by 0."); 
				return;
			}  
			break;  
		}
		calculator.displayLabel.setText(CalculatorApp.getFormattedText(temp)); 
		//set the displayed number at the top to whatever number is newly produced with these operator
	} 
}

