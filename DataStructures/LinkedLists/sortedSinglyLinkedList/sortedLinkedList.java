
/* 
	A sorted linked list that inserts links based on data size
	There are two constructors, one for initializing the list, another if an array needs to
	be passed in, for sorting purposes. (Inputting an unsorted array, then inserting it into 
	a sorted linked list will sort it faster than sorting it within the array)
*/


class Link{

	public int data;
	public Link next;

	public Link(int d){
		data = d;
	}
}


class SortedLinkedList{

	private Link first;

	public SortedLinkedList(){
		first = null;
	}

	public SortedLinkedList(Link[] linkArray){
		first = null;
		for(int i = 0; i < linkArray.length; i++){
			insert(linkArray[i]);
		}
	}


	public void insert(Link newLink){
		Link previous = null;
		Link current = first;

		while(current != null && newLink.data > current.data){
			previous = current;
			current = current.next;
		}

		if(previous == null){
			first = newLink;
		}
		else{
			previous.next = newLink;
		}
		newLink.next = current;
	}

	public Link remove(){
		Link temp = first;
		first = first.next;
		return temp;
	}
}