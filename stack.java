
public class stack {
private int maxSize;
private char []stackArray;
private int top;

//constructor
public stack(int s){
	this.maxSize=s;
	this.stackArray= new char[s];
	this.top=-1;
}

public void push(char c){
	this.stackArray[++top]=c;
}
public char pop(){
	return this.stackArray[top--];
}
public char peek(){
	return this.stackArray[top];
}
public boolean isEmpty(){
	return top==-1;
}
public boolean isFull(){
	return top==maxSize-1;
}
public int size(){
	return top+1;
}
public char peekN(int n){
	return this.stackArray[n];//peek at n
}
public void displayStack(String s){
	System.out.println(s);
	System.out.print("Stack (bottom -->top): ");
	for(int i=0;i<size();i++){//get the size from bottom to top
		System.out.print(peekN(i));//peek at each element of the stack from bottom to top
		System.out.print(' ');
	}
	System.out.println();
}

}//end of class stack
