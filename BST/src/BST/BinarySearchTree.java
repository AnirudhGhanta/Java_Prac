package BST;
/**
 * 
 */

/**
 * @author aniru
 *
 */

public class BinarySearchTree<T extends Comparable<T>> {
	Node<T> root;
	int size;
	
	public BinarySearchTree(T value) {
		root = new Node<T>(value);
		size = 1;
	}
	
	public BinarySearchTree() {
		root = null;
		size = 0;
	}
	
	// insert a value
	void insert(T value) {
		root = add(root, value);
	}
	
	private Node<T> add(Node<T> node, T value){
		
		// if the tree is empty set it to root
		if(node == null) {
			node = new Node<T>(value);
			return node;
		}
		
		// look for the right place to put the value
		if(value.compareTo(node.getValue()) < 0) {
			node.setLeft(add(node.getLeft(), value));
		}
		else if(value.compareTo(node.getValue()) > 0) {
			node.setRight(add(node.getRight(), value));
		}
		
		return node;
	}
	
	public void printTree() {
		inorder(root);
	}
	
	private void inorder(Node<T> node) {
		if(node != null) {
			inorder(node.getLeft());
			System.out.println(node.getValue());
			inorder(node.getRight());
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> num_bst = new BinarySearchTree<Integer>(10);
		num_bst.insert(5);
		num_bst.insert(11);
		num_bst.insert(7);
		num_bst.insert(4);
		num_bst.insert(8);
		num_bst.insert(25);
		num_bst.insert(13);
		
		num_bst.printTree();
		
		return;
	}
}
