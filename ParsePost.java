public class ParsePost {
private stackX theStack;
private String input;

public ParsePost(String in){
	input=in;
}

public int doParse(){
	int size=input.length();
	theStack= new stackX(size); //new object theStack of size
	char ch;
	int num1, num2, interAns;
	
	for(int i=0;i<input.length();i++){ //check from the first character till the last element
		ch=input.charAt(i); //check at each character at a time
		
		theStack.displayStack("For: "+ch+" ");
		
		//if ch is an operand, push it to the stack
		
		if(ch>='0'&&ch<='9'){
			theStack.push((int)ch-'0'); //as its an integer push it to the stack
		}else{
			//its an operator. Therefore, if its an operator pop two operands and do the arthmatic, and push it back to the stack
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


}
