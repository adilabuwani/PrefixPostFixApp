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
		theParser.pushSymtab(input);  //push the variable to symtab
		}
		else if(input.length()>1){  //input is an expression, evaluate to postfix first
			//this is for both convert to postfix <<<<<<<<<<<<<<
			theTrans= new InToPost(input);
			output=theTrans.doTrans();
			System.out.println("Postfix: "+output);
			//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			//check if symtab is empty
			if(theParser.SybTabEmpty()){ //if symtab is empty, set as input
				theParser.setInput(output);
				theParser.setVariable(keyb); //set variables from keyb, and push to symtab
				int result=theParser.doParse();  //do translation
				System.out.println("Evaluates: "+result);
				
			
			}else{  //symtab not empty, set variables do translation
				theParser.setInput(output);
				int result=theParser.doParse();  //do translation
				System.out.println("Evaluates: "+result);
				
			}
			
			
		}//end else if
		else{ //else lookup the value from Symtab, and return back the value
			
			
		}//end else
      } //end while(true)
		
		
	}
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
	
		return s;
		
	}
}
