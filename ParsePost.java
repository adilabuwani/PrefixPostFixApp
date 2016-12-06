import java.util.*;

public class ParsePost {
Stack<Integer> theStack;
private SYMTAB theSymtab;
private String input;     
private int size;

//constructor
public ParsePost(String in){
	input=in;               //takes in input as a PostFix
	size=input.length();    //store the length
	theSymtab= new SYMTAB(size); 
	theStack=new Stack<Integer>();// new generic stack called theStack
}
public ParsePost(){
	input="";               //no input yet
	size=10;    //default  length set to 10, we will resize this
	theSymtab= new SYMTAB(); //symtab by default set to size 10
	theStack= new Stack<Integer>();//Generic Stack of integer
}

//accessors
public int getOperand(){ //get number of operands present in the postfix expression
	int count=0;    //counts the number of operands present
	char ch;
	for(int i=0;i<input.length();i++){
		 ch=input.charAt(i); //each character at a time
		 if(this.IsOperand(ch)&&!this.isInteger(ch)){  //is operand and not an integer
			 count++;            //if is operand, increment
		 }
	} //end for
	return count;  //return the number of operands present
} //end getOperands

//mutators
public void setInput(String in){
	this.input=in;
	this.size=input.length();
	
}

public void setVariable(Scanner keyb){  //set variables from keyboard
	int NumOperands=this.getOperand(); //get the number of operands
	String in="";
	      //new object of Symtab, to store var, and value
	
	while(NumOperands!=0){
	System.out.println("Enter value for your variables e.g- a=4");
	in=keyb.nextLine(); //get from keyboard
	
	if(this.IsValidExp(in)){ //if is a valid expression
	
	String []SplitInput=in.split("="); //split it to an array 	
	 
	char varChar=SplitInput[0].charAt(0); //the first index is a variable
	
	String val= SplitInput[1];//the next index is a value
	if(val.contains(";")){ // contains a semicolom?
		val=val.replaceAll(";","");
		val.trim();			//remove whitespace from front and back
	}
	
	int val1=Integer.parseInt(val); //parse to integer
	
	theSymtab.insert(varChar, val1);    //push to Symtab
	
	System.out.println("Pair");
	
	NumOperands--; //decrement number of operands
	
	}else{
		System.out.println("Something went wrong, Please try again: ");
	}
	
  } //end while
	
}

public int doParse(){
	
	char ch;
	int num1, num2, interAns;
	
	for(int i=0;i<input.length();i++){ //check from the first character till the last element
		ch=input.charAt(i); //look at each character at a time
		//if ch is an operand, lookup the value, and push it to the stack
		if(this.IsOperand(ch)&&!this.isInteger(ch)){//if ch is operand and NOT an iteger 
			int val=this.theSymtab.LookUp(ch); //lookUp the value
			theStack.push(val); //if is an operand, push to the stack
		}else if(this.IsOperand(ch)&&this.isInteger(ch)){
		theStack.push(Character.getNumericValue(ch)); //push numeeric value of ch
			
		}else{	//its an operator. Therefore, if its an operator pop two operands and do the arthmatic, and push it back to the stack
			num2=theStack.pop();
			num1=theStack.pop();
			
			switch(ch){
			case '+':
				interAns=num1+num2;
				break;
			case '-':
				interAns=num1-num2;
				break;
			case '*':
				interAns=num1*num2;
				break;
			case '/':
				interAns=num1/num2;
				break;
				default:
				interAns=0;	
			}//end switch
			theStack.push(interAns); //Do the arthmetic, and push the result BACK IN THE STACK
		}
	}//end for
	//pop the final result
	interAns=theStack.pop();
	return interAns; //return the final result
}
public boolean IsOperand(char ch){ //return true if the character is an operand
	if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){ //is operator
		return false;  
	}
	return true; //is operand
}

public boolean IsValidExp(String in){
	
	//check for whitespace
if(in.contains("=")&& in.length()>=3){ //if contains an equal sign, and the length is atleast three
	return true;	 //is in valid form
	}
return false; //not in valid form
}


public void clearSymtab(){
	this.theSymtab.clear();  //clear symtab
}

public boolean isInteger(char ch){
	return (ch>'1'&&ch<='9');         //return true if integer
}


//push variables to symtab
public void pushSymtab(String in){
	
	if(this.IsValidExp(in)){ //if is a valid expression
		
		String []SplitInput=in.split("="); //split it to an array 	
		 
		char LHS=SplitInput[0].charAt(0); //the first index is a variable
		
		String val= SplitInput[1];//the next index is a value
		if(val.contains(";")){ // contains a semicolom?
			val=val.replaceAll(";","");
			val.trim();			//remove whitespace from front and back
		}
		
		int RHS=Integer.parseInt(val); //parse to integer
		
		theSymtab.insert(LHS, RHS);    //push to Symtab
		
		System.out.println("Pair");

}else{
	System.out.println("Something went wrong, try again");
}
	
} //end pushSymtab

public boolean SybTabEmpty(){
	if(this.theSymtab.isEmpty()){
		return true;
	}else{
		return false;
	}
}
///////////////////////////////////////



}
