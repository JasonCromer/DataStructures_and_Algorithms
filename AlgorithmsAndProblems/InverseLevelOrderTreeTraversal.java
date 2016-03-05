import java.util.*;


/*
	Given the following tree, perform a Level Order Inverse traversal of the 
	binary tree and print it out.

							10
						6			15
					22			17			35
				1			65			12		54


	Output should be:
	1
	65
	12
	54
	22
	17
	35
	6
	15
	10

*/

public class InverseLevelOrderTreeTraversal{

	public static void main(String[] args){

		TreeNode root = buildTree();
		//new InverseLevelOrderTreeTraversal().printInOrder(root);	
		new InverseLevelOrderTreeTraversal().printLevelOrderInverseTraversal(root);
	}


	//Lazy build of a tree. 
	private static TreeNode buildTree(){
		TreeNode root = new TreeNode(10);
		TreeNode nodeR1 = new TreeNode(15);
		TreeNode nodeL1 = new TreeNode(6);
		TreeNode nodeRR2 = new TreeNode(35);
		TreeNode nodeRL2 = new TreeNode(17);
		TreeNode nodeLL2 = new TreeNode(22);
		TreeNode leafLL = new TreeNode(1);
		TreeNode leafRL = new TreeNode(65);
		TreeNode leafRR1 = new TreeNode(12);
		TreeNode leafRR2 = new TreeNode(54);

		root.right = nodeR1;
		root.left = nodeL1;
		nodeL1.left = nodeLL2;
		nodeLL2.left = leafLL;
		nodeR1.left = nodeRL2;
		nodeR1.right = nodeRR2;
		nodeRL2.left = leafRL;
		nodeRR2.left = leafRR1;
		nodeRR2.right = leafRR2;

		return root;
	}


	/*	This method prints out the tree in Inverse Level Order Traversal.
		It does so by somewhat of a breadth-first search, adding the next
		level nodes to a queue. After checking each child node and adding
		to the queue, the root will be pushed to a stack.
		This essentially adds (starting from the left), each level of
		nodes in the binary tree to a stack. When we are done, popping
		the stack will print out the binary tree in inverse level order,
		starting at the bottom, right-most node.
	*/
	public void printLevelOrderInverseTraversal(TreeNode root){
		if(root != null){
			Stack<TreeNode> stack = new Stack<>();
			Queue<TreeNode> queue = new LinkedList<>();

			//Add our root to the queue
			queue.add(root);

			while(!queue.isEmpty()){

				//Get root object, removing it from the queue
				root = queue.poll();

				//If root has a right child, add it to the queue
				if(root.right != null){
					queue.offer(root.right);
				}

				//If root has a left child, add it to the queue
				if(root.left != null){
					queue.offer(root.left);
				}

				//Push root to the queue
				stack.push(root);
			}

			while(!stack.isEmpty()){
				System.out.println(stack.pop().value);
			}
		}
	}


	//TreeNode class which contains data, left and right node fields
	static class TreeNode{
		int value;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val){
			value = val;
		}
	}
}