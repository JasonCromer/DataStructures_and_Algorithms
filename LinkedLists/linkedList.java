class Link {
	int key;
	int data;
	Link next;

	public Link(int key, int data){
		this.key = key;
		this.data = data;
	}

	public void displayLink(){
		System.out.println("\n{" + this.key + ", " + this.data + "}");
	}
}



class LinkedList {
	private Link first;

	public LinkedList(){
		first = null;
	}


	public void insertFirst(int key, int data){
		Link newLink = new Link(key, data);
		newLink.next = first;
		first = newLink;
	}

	public Link find(int key){
		Link current = first;
		while(current.key != key){
			if(current.next == null){
				return null;
			}
			else{
				current = current.next;
			}
		}
		return current;
	}

	public Link delete(int key){
		Link current = first;
		Link previous = first;

		while(current.key != key){
			if(current.next == null){
				return null;
			}
			else{
				previous = current;
				current = current.next;
			}
		}

		if(current == first){
			first = first.next;
		}
		else{
			previous.next = current.next;
		}

		return current;
	}


	public void displayList(){
		Link current = first;

		System.out.println("\nPrinting List:");
		while(current != null){
			current.displayLink();
			current = current.next;
		}
	}
}



class Main {
	public static void main(String[] args){
		LinkedList list = new LinkedList();

		list.insertFirst(1, 20);
		list.insertFirst(1, 50);
		list.insertFirst(2, 64);
		list.insertFirst(10, 34);
		list.insertFirst(3, 70);

		list.displayList();

		Link item = list.find(2);
		if(item != null){
			System.out.println("\nItem key: " + item.key + " Item data: " + item.data);
		}
		else{
			System.out.println("\nCouldn't find key");
		}


		Link deleted = list.delete(2);
		if(deleted != null){
			System.out.println("\nItem deleted. Item key: " + item.key + " Item data: " + item.data);
		}
		else{
			System.out.println("\nCouldn't find key");
		}

		list.displayList();
	}
}