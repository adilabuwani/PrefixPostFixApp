import java.util.*;
public class InfixApp {
	
	public static void main(String[] args){
		String input, output;
		char uInput;
		Scanner keyb= new Scanner(System.in);
		while (true){
			System.out.println("Enter Infix e.g: y=a+b; ");//ask the user for input
			input=keyb.nextLine(); //from the keyb(object.method)
			
			if(input.equals(" ")||!input.contains("=")){ break;}

			InToPost theTrans= new InToPost(input); //assign input
			
			output=theTrans.doTrans();// do the translation in postfix, and assign to output
			
			System.out.println("Postfix is:"+output);//print output
			
			//to evaluate the postfix expression:
			ParsePost theParser= new ParsePost(output);
			//set variables from user 
			theParser.setVariable(keyb);
			System.out.println("Evaluates to: "+theParser.doParse());
			
			while(true){
				System.out.println("Would you like to use same values assigned to variables for evaluating the next expression? Y/N");
				 uInput=keyb.nextLine().charAt(0);
				 if(uInput!='y'){
					 theParser.clearSymtab(); //clear the saved variables in symtab
					 break;
				 }
					System.out.println("Enter Infix: ");//ask the user for input
					input=keyb.nextLine(); //from the keyb(object.method)
					
					InToPost theTran= new InToPost(input); //do the translation in postfix
					
					String postFix=theTran.doTrans();
					System.out.println("Postfix Is:"+postFix);
					
					theParser.setInput(postFix); //set input as the postfix expression
					System.out.println("Evaluates to: "+theParser.doParse());
				
			}	
			
       }//end while
		keyb.close(); 
	}
}
