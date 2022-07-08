package calculatorApp;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DigitButtons extends Button implements ActionListener  
{  //this class is responsible for all the digit numbers buttons and their actions
	CalculatorApp calculator;  


	DigitButtons(int x,int y, int width,int height,String cap, CalculatorApp clc)  
	{  
		super(cap);  
		setBounds(x,y,width,height);  
		this.calculator=clc;  
		this.calculator.add(this);  
		addActionListener(this);  
	}  

	static boolean isInString(String s, char ch)  
	{  
		for(int i=0; i<s.length();i++) 
			if(s.charAt(i)==ch) return true;  
		return false;  
	}  

	public void actionPerformed(ActionEvent ev)  
	{  
		String tempText=((DigitButtons)ev.getSource()).getLabel();  

		if(tempText.equals("."))  
		{  //if the user enters a decimal point, check if the whole calculator is clear
			if(calculator.clear)   
			{//if there is no numbers before the decimal point, add a 0 before the decimal point to properly show the number
				calculator.displayLabel.setText("0.");
				calculator.clear=false;
			}  
			else if(!isInString(calculator.displayLabel.getText(),'.')){
				//if there are numbers before the decimal point, then add a decimal point after the previous number
				//ex. 3 + clicks decimal point  ==  3.
				calculator.displayLabel.setText(calculator.displayLabel.getText()+".");  
			}
			return;  
		}  

		int index=0;  
		try{  //try parsing the integer to check if a numberformat exception occurs
			index=Integer.parseInt(tempText);  
		}
		catch(NumberFormatException e)
		{//if an exception is caught, return nothing
			return;
		}  

		if (index==0 && calculator.displayLabel.getText().equals("0")) {
			//if no number is entered, return nothing
			return;  
		}

		if(calculator.clear)  
		{//if there is no numbers in the textfield, add whatever number was selected into the textfield 
			calculator.displayLabel.setText(""+index);
			calculator.clear=false;
		}  
		else {  
			////if there is numbers in the textfield already, merge the two numbers together
			calculator.displayLabel.setText(calculator.displayLabel.getText()+index);  
		}
	}
}  