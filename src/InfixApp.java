//NAME:ADIL ABUWANI
//CONTACT : ADIL.ABUWANI@OUTLOOK.COM
//DESCRIPTION: INFIX-POSTFIX EVALUATOR
//README FOR MORE DETAILS
//DATE:12/13/2016

import java.io.*;
import java.util.*;
public class InfixApp {

	public static void main(String[] args)throws IOException{
		Scanner keyb= new Scanner(System.in);
		String input, output;
		InToPost theTrans;
		ParsePost theParser= new ParsePost();
		while (true){
			System.out.print(">>");
			input=getString();       //user input

			//input contains =, then its assigning first
			if(input.contains("=")){  
				theParser.pushSymtab(input);  //push the variable to symtab table
			}
			
			else if(isExpression(input)){  //input is an expression, evaluate to postfix first
				//this is for both convert to postfix 
				theTrans= new InToPost(input);
				output=theTrans.doTrans();
				System.out.println("Postfix: "+output);
			
				//check if symtab is empty
				if(theParser.SybTabEmpty()){ //if symtab is empty, set input from user first
					theParser.setInput(output);
					theParser.setVariable(keyb); //set variables from user, and push to symtab
					int result=theParser.doParse();  //do translation
					System.out.println("Evaluates: "+result);

				}else{  //symtab not empty, set variables do translation
					theParser.setInput(output);
					int result=theParser.doParse();  //do translation
					System.out.println("Evaluates: "+result);
				}
			}//end else if
			else{ //else lookup the value of operand from Symtab, and return back the value
				if(theParser.LookUp(input)==-1){
					notFound(input);  //input not found

				}else{
					System.out.println(theParser.LookUp(input));
				}
			}//end else
		} //end while(true)

	}//end main
	///////////////////////////////////////////////////////////////////////////////////////////

	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		s=s.replaceAll(" ", "");  //remove whitespace
		s=s.replaceAll(";", "");  //remove semicoln
		return s;
	}

	public static void notFound(String in)throws IOException{
		System.out.println(in+" was not found!");
	}

	public static boolean isExpression(String in){
		return (in.length()>2);
	}
}
