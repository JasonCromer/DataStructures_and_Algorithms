/*
	Use stack to check matching brackets.
	First we create an instance of the Stack object. After that, we
	iterate through the string and switch case, then push each bracket delimeter i.e. "[,{,(..."
	to the Stack then break. We then switch case and, if stack is not empty, we pop the value.
	We must then check if the delimeters in our switch statements have their appropriate closing 
	brackets. */

//General stack class that takes in chars
class Stack {

	private int maxSize;
	private char[] stackArray;
	private int top;
	
	public Stack(int maxSize){
		maxSize = maxSize;
		stackArray = new char[maxSize];
		top = -1;
	}

	public void push(char value){
		if(!isFull()){
			top += 1;
			stackArray[top] = value;
		}
	}

	public char pop(){
		if(!isEmpty()){
			top -= 1;
			return stackArray[top];
		}
	}

	public char peek(){
		return stackArray[top];
	}

	public boolean isEmpty(){
		return (top == -1);
	}

	public boolean isFull(){
		return (top == maxSize - 1);
	}
}



//Checks if brackets are closed
class BracketChecker {
	private String input;

	public BracketChecker(String in){
		input = in;
	}

	public void check(){
		int stackSize = input.length();
		Stack myStack = new Stack(stackSize);

		for(int i = 0; i < stackSize; i++){
			char bracket = input.charAt(i);

			switch(bracket){
				case '{':
				case '[':
				case '(':
					myStack.push(bracket);
					break;

				case '}':
				case ']':
				case ')':
					char bracketx = myStack.pop();
					if( (bracket=='}' && bracketx != '{' ||
						bracket==']' && bracketx != '[' ||
						bracket==')' && bracketx != '(')){
							System.out.println("Error with delimeter");
						}
			}
		}
	}
}