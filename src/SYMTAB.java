
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
	if(count==-1){  //first element
		count++;    //inc count
		name[count] = var;
		value[count]= val;
	  }else{
		  this.SetLhsRhs(var, val);
	  }
   }//end insert
 
public void SetLHS(char var, int val){    //find LHS in Symtab and replace with new RHS
	  for(int i=0; i<=count; i++){
			if ( name[i]==var ){ 
				   value[i]=val;
			}
	}
}
  
  public int LookUp(char var) {
	  for(int i=0; i<=count; i++){
		if ( name[i]==var){ 
			  return value[i]; //return the value of the var
		}
	  }
		return -1;   //by default -1
  }
  
  public boolean SetLhsRhs(char var, int val){
	  for(int i=0; i<=count; i++){
			if ( name[i]==var){     //found element with same var, replace 
				 name[i]=var;
				 value[i]=val;
				  return true; 
			} //end if
		  }//end for
	  //couldnt find element
	  count++;  //increment count
	  name[count] = var;        //push var and val to top of SymTab
	  value[count]= val;
	  return false;       
  }
  
  public void resize(int size)  { 
	    N = size;
		name = new char[N];
		value = new int[N];
		count = -1;  // empty count
}
} //END CLASS
