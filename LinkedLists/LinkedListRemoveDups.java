import java.util*;


/*
	Remove duplicates from an unsorted linked list
*/


class Main {

	public static void main(String[] args){
		LinkedListNode node = new LinkedListNode(someData);
		deleteDups(node);
	}

	public static void deleteDups(LinkedListNode n) {
		Hashtable table = new Hashtable();
		LinkedListNode previous = null;
		while(n != null){
			if(table.containsKey(n.data)){
				previous.next = n.next;
			}
			else{
				table.put(n.data, true);
				previous = n;
			}
			n = n.next;
		}
	}
}
