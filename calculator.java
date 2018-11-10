/* This Class evaluates an infix expression which is fully parenthesized using stacks
 * Example input : (((3+4) * 5 ) / 7)
 * output : Final Result: 5
 *
 */
import java.io.*; 
import java.util.*; 

public class Calculator{
	
	// input string [infix string] that holds the expression to evaluate
	String input;
	
	// result 
	int result;
	
	public Calculator(String val){
		input = val;
		result = 0;
	}
	
	void evaluate(){
		// initialize a stack
		Stack<Character> stack = new Stack<>();
		
		// bool to check the status
		boolean status = true;
		
		// scan the elements in the input string one by one
		for( char ele : input.toCharArray() ){
			
			// if the ele is anything other than a closing bracket we push it on to the stack.
			if(ele != ')'){
				stack.push(ele); 
			}
			// this ele - '0' operation automatically converts a char to int because of the '-' operator
			// if ele is ) we pop 4 items out of the stack, opnd1 -- operator -- opnd2 -- opening bracket )
			// if the stack has not enough operands, we set the result to 0 and exit the program.
			else{
				if(stack.size() >= 4){
					int opnd1 = stack.pop() - '0';
					char oper = stack.pop();
					int opnd2 = stack.pop() - '0';
					stack.pop(); // discard the opening backet
					
					switch(oper){
						case '+' : 
							stack.push((char)((opnd2+opnd1) + '0'));
							break;
						case '-' : 
							stack.push((char)((opnd2-opnd1) + '0'));
							break;
						case '*' : 
							stack.push((char)((opnd2*opnd1) + '0'));
							break;
						case '/' : 
							stack.push((char)((opnd2/opnd1) + '0'));
							break;
					}
				}
				else{
					status = false;
					break;
				}
			}
		}
		// set the result
		if(status)	this.result = stack.pop()-'0';
	}
	
	public static void main(String a[]){
		// fully parenthesized input string 
		Calculator calc = new Calculator("(((3+4)*5)/7)");
		// call the evaluate method
		calc.evaluate();
		// print out the result
		System.out.println("Final Result: "+calc.result);
	}
}