//Implement a Queue using two stacks


class myQeueue<T> {
	Stack<T> oldStack, newStack;

	public myQeueue(){
		newStack = new Stack<T>();
		oldStack = new Stack<T>();
	}

	public int stackSize(){
		return newStack.size() + oldStack.size();
	}

	public void add(T value){
		newStack.push(value);
	}

	private void shiftStack(){
		if(oldStack.isEmpty()){
			while(!newStack.isEmpty()){
				oldStack.push(newStack.pop());
			}
		}
	}

	public void peek(){
		shiftStack();
		oldStack.peek();
	}

	public void remove(){
		shiftStack();
		oldStack.peek();
	}
}