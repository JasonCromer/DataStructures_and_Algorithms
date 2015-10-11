


//Implement a simple array queue


class Queue{
	private int maxSize;
	private int[] queArray;
	private int front;
	private int back;
	private int nItems;

	public Queue(int size){
		maxSize = size;
		queArray = new int[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	public void insert(int data){

		//wrap queue if we overflow
		if(rear == maxSize -1){
			rear = -1;
		}
		rear++;
		queArray[rear] = data;
		nItems++;
	}

	public int remove(){
		int temp = queArray[front];
		front++;
		//wrap front of queue if we overflow
		if(front == maxSize){
			front = 0;
		}
		nItems--;

		return temp;
	}

	public int peekFront(){
		return queArray[front];
	}

	public boolean isEmpty(){
		return nItems == 0;
	}

	public boolean isFull(){
		return nItems == maxSize;
	}

	public int size(){
		return nItems;
	}
}