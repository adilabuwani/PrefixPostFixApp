//NAME:ADIL ABUWANI
//CONTACT : ADIL.ABUWANI@OUTLOOK.COM
//DESCRIPTION: INFIX-POSTFIX EVALUATOR
//README FOR MORE DETAILS
//DATE:12/13/2016

import java.util.*;

public class InToPost {
private Stack<Character> theStack;
private String input;
private String output="";

public InToPost(String in){
     this.input=in;		
     theStack = new Stack<Character>(); 
}

public String doTrans(){
	for(int i=0;i<input.length();i++){//we will test for each character at a time
		
		char ch=input.charAt(i);//ch is the character at each index
		switch(ch){
		case '+':
		case '-':
			gotOper(ch, 1); //got a lower precedence arthemetic, 1 for lower precedence
			break;
		case '*':
		case '/':
			gotOper(ch, 2);// has a higher precedience of 2
			break;
		case '(':
			theStack.push(ch);//if reading an ( then always push it to the stack
			break;
		case ')':
			gotParen(ch);//closing perentesis, we will deal with it now.. The stack will Never be empty as ( has been pushed
			break;
		default : //must be an operand, then write to output
			output=output+ch; //if is an operand, then write to output
			break;
		}//end switch

	}//end for
	//the remaining operators pop all the remaining operators
	while(!theStack.isEmpty()){

		this.output=output+theStack.pop();//write the remaining elements and pop to output
	}
	return output;
		
}
public void gotOper(char opThis, int precThis){//check the opThis
	//while the stack is not empty, pop an item OpTop
	while(!theStack.empty()){
		char opTop=theStack.pop();//POP AN ITEM
		
		if(opTop=='('){//if opTop is an open perentests, we push it back as we know 
		theStack.push(opTop);//push the opTop back, and exit the loop(if we dont exit it will always be running 
		break;//push the '(' back and exit the loop, so we can push the ch
		}
		else{//if is not a bracket, but simple expression A+B-C
			int precTop;
			if(opTop=='+'||opTop=='-'){//if we pop and is a +/-
				precTop=1;//as it is a small precidence
			}else{//else we know that opTop has a higher presidence *or /
				precTop=2;
			}
			
			if(precTop<precThis){//if the prec of Top is smaller then prec of this
				theStack.push(opTop); //then push it back as precThis has a higher prec
				break;
			}
			else{ //else its definitly equal so we will write to output
				output=output+opTop;
			}
		}
		}//end while
//if the stack is empty OR -- is anything includiBg (, OR if small precidence BEONG PUSHED, THEN THE NEXT OPERATOR HAS TP BE PUSHED
	theStack.push(opThis);
}

public void gotParen(char ch){
	// the stack is definitly not empty
	while(!theStack.empty()){
		//if its a closing parentasis, we will pop an item 
		char chx=theStack.pop();//so, pop an item
		if(chx=='('){
			break;  //if pop (, we will get off the loop, as we are done
		}else{ //write to output till we reach the (, and exit the loop as we will be done
			output=output+chx;
		}
	}//end while
}



}//end of class
