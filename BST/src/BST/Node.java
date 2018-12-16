package BST;

/**
 *  Node class to hold the value of the object and links to its children
 */
	
/**
 * @author aniru
 *
 */
public class Node<T> {

	private T key;
	private Node left, right;
	int height;
	int depth;
	
	public Node(T value) {
		key = value;
		left = right = null;
		height = depth = 0;
	}
	
	public T getValue() {
		return key;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}
