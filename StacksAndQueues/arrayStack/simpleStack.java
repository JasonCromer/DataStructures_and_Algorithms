

//Simple stack implementation using arrays



class Stack {
	private int maxSize;
	private int[] stack;
	private int top;

	//constructor
	public Stack(int size){
		maxSize = size;
		stack = new int[maxSize];
		top = -1;
	}


	public void push(int d){
		if(!isFull()){
			top++;
			stack[top] = d;
		}
	}

	public int pop(){
		if(!isEmpty()){
			int temp = stack[top];
			top--;
			return temp;
		}
		else{
			return -1;
		}
	}

	public int peek(){
		if(!isEmpty()){
			return stack[top];
		}
		else{
			return -1;
		}
	}

	public boolean isEmpty(){
		return top == -1;
	}

	public boolean isFull(){
		return top == maxSize -1;
	}
}