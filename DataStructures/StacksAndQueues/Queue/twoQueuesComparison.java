/* 
	Use the queue datastructure to implement two queues that would keep track of
 	the oldest dogs and cats in an animal shelter. The buyer of the animal of 
 	his/her choice must be the oldest animal of that type.
 	Implement an enqueue, dequeueAny, deqeueDog and dequeueCat method.
 */


 	public abstract class Animal {
 		private int order;
 		private String type;
 		protected String name;

 		//constructor
 		public Animal(String n, String t){
 			name = n;
 			type = t;
 		}

 		public void setOrder(int ord){
 			order = ord;
 		}

 		public int getOrder(){
 			return order;
 		}

 		public void setType(int t){
 			type = t;
 		}

 		public String getType(){
 			return type;
 		}

 		public boolean isOlderThan(Animal a) {
 			return this.order < a.getOrder();
 		}
 	}


 	public class AnimalQueue {
 		LinkedList<Dog> dogs = new LinkedList<>();
 		LinkedList<Cat> cats = new LinkedList<>();

 		//order acts as a timestamp
 		private int order = 0;

 		public void enqueue(Animal a){
 			a.setOrder(order);
 			order++;

 			if(a.getType().equals("Dog")){
 				dogs.addLast((Dog) a);
 			}
 			else{
 				cats.addLast((Cat) a);
 			}
 		}

 		public Animal dequeueAny() {
 			if(dogs.size() == 0){
 				return dequeueCats();
 			}
 			else if(cats.size() == 0){
 				return deqeueDogs();
 			}

 			Dog dog = dogs.peek();
 			Cat cat = cats.peek();

 			if(dog.isOlderThan(cat)){
 				return deqeueDogs();
 			}
 			else{
 				dequeueCats();
 			}
 		}

 		public Dog dequeueDogs(){
 			return dogs.poll();
 		}

 		public Cat dequeueCats(){
 			return cats.poll();
 		}
 	}

 	public class Dog extends Animal {
 		public Dog(String n, t){
 			super(n, t);
 		}
 	}

 	public class Cat extends Animal {
 		public Cat(String n, t){
 			super(n, t);
 		}
 	}