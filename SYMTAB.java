
public class SYMTAB {
	private char name[];
	private int value[];
	private int count; 
	private int N;
	//default constructor
public SYMTAB(){   
	resize(10);
}// default to 10

public SYMTAB(int size){
	this.resize(size);
}

public void clear(){ //will clear and resize to the original size
	resize(N);   
	}
 
public boolean isEmpty(){  //return true if empty
	 return count==-1; 
   }

 public int sizeof(){  //returns the size
	  return count+1;   
	  }
  
public void insert(char var, int val) {
	  count++;         // empty count fix
	  name[count] = var;
	  value[count]= val;
   }
 
public void SetLHS(char var, int val){
	  for(int i=0; i<=count; i++){
			if ( name[i]==var ){ 
				   value[i]=val;
	  // ouch.... what if not found???
			}
	}
}
  
  public int LookUp(char var) {
	  for(int i=0; i<=count; i++){
		if ( name[i]==var){ 
			  return value[i]; //return the value of the var
		}
	  }
		return -1; // ouch.. needs EXCEPTION
  }
  public void resize(int size)  { // Ouch.. copy ???
	    N = size;
		name = new char[N];
		value = new int[N];
		count = -1;  // empty count fix  
}
} //END CLASS
