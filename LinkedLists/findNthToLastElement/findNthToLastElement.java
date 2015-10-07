import java.utils*;


/*
	Implement  an algorithm to find the nth to last element of a singly linked list

	Algorithm:
	1. create two pointers, p1 and p2
	2. Incremenet p2 by n-1 positions, making the distance between p1 and p2 equal to n.
	3. If p2->next is equal to null, that means p2 is the last item, therefore p1 is n distance away from the last element
	4. Else, keep incrementing p1 and p2 by 1 position until p2->null.
*/





class Main {

	private static void main(String[] args) {
	}


	private static LinkedListNode nthToLast(LinkedListNode head, int n){
		if(head == null || n < 1){
			return null;
		}

		LinkedListNode p1 = head;
		LinkedListNode p2 = head;

		//incremement p2 until we hit n-1 position (or until p2 is null)
		for(int j = 0; j < n-1; j++){
			if(p2 == null) {
				return null;
			}
			p2 = p2.next;
		}

		//Incremement until p2->next is null. Only then will p1 be in the nth position
		//from the last node (since p2 is n-1 ahead of p1)
		while(p2.next != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
}


