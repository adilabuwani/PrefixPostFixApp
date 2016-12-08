import java.util.*;
public class InfixApp {

	public static void main(String[] args){
		String input;
		String output;
		int parseExp;
		
		Scanner keyb= new Scanner(System.in);
		
		while (true){
			
			System.out.println("Enter Infix: ");//ask the user for input
			input=keyb.nextLine(); //from the keyb(object.method)
			
			if(input.equals(" ")||input.equals("")){
				break;
			}
			
			InToPost theTrans= new InToPost(input); //do the translation in postfix
			
			output=theTrans.doTrans();// do the translation in postfix, and assign to output
			
			System.out.println("POSTFIX IS:"+output+'\n');//print output
			
			System.out.println("Evaluating the postfix expression: "+output);
			
			//to evaluate the postfix expression:
			ParsePost theParser= new ParsePost(output);
			parseExp=theParser.doParse(); //evaluate the postfix expression, and assign to parseExp
			System.out.println("Evaluates to: "+parseExp);
			
       }//end while
		keyb.close(); 
	}
}
