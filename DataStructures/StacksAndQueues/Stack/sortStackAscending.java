//Sort a stack in ascending order using only one other stack
//This is performed in O(n^2) time and uses O(n) space

public static Stack<Integer> sort(Stack<Integer> firstStack){
	Stack<Integer> secondStack = new Stack<>();

	while(!firstStack.isEmpty()){
		int temp = firstStack.pop();

		while(!secondStack.isEmpty() && temp < secondStack.peek()){
			firstStack.push(secondStack.pop());
		}
		secondStack.push(tmp);
	}
	return secondStack;
}