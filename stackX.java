
public class stackX {
public int maxSize;
public int []StackArray;
public int top;

public stackX(int s){
	this.StackArray=new int[s]; //a reference to an array of size s
	this.maxSize=s; //max size of s
	this.top=-1; 
}
public void push(int a){ //pushes the value to the top
	this.StackArray[++top]=a;
}
public int pop(){         //returns the value being removed from the top
	return StackArray[top--];
}
public int peek(){ //peek at the value of the top without removing it
	return this.StackArray[top];
}
public boolean isEmpty(){ //return true f the stack is not empty
	return (top==-1);
}
public boolean isFull(){ //return true if the stack is full
	return (top==this.maxSize-1);
}
public int size(){
	return top+1; //return the size of the stack
}
public int peekN(int n){ 
    return StackArray[n]; 
}
public void displayStack(String s){
System.out.print(s);
System.out.print("Stack (bottom-->top): "); 
for(int i=0;i<size();i++){
	System.out.print(peekN(i));
	System.out.print(' ');
}
System.out.println("");
		
}

}