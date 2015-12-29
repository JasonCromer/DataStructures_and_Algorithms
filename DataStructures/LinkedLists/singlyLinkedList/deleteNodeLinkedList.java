class Node {
	Node next = null;
	int data;

	public Node(int d){
		this.data = d;
	}


	public void appendToTail(int d){
		Node end = new Node(d);
		Node n = this;
		while(n.next != null){
			n = n.next;
		}
		//After hitting last element, append our data to the tail
		n.next = end;
	}

	public Node deleteNode(Node head, int d){
		Node n = head;

		if(n.data == d){
			return head.next; //moved head
		}

		while(n.next != null){
			if(n.next.data == d){
				n.next = n.next.next; //We found our item! Time to replace with the one ahead of it
				return head;
			}
			n = n.next; //nullify n
		}
		return head;
	}

}
