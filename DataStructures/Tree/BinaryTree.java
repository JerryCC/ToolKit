import java.util.NoSuchElementException;

public class BinaryTree<T extends Comparable<T>>{
	
	public class Node<T>{
		public T value;
		public Node left;
		public Node right;
		public Node(T v, Node<T> left, Node<T> right){
			this.value = v; 
			this.left = left; 
			this.right = right;
		}
		public Node(T v){this(v, null, null);}
	}

	private Node<T> root;

	public BinaryTree(T value){
		this.root = new Node(value);
	}
	
	private Node<T> insertHelper(Node<T> cur, T value){
		if (cur == null){
			cur = new Node(value);
			return cur;
		} else if (cur.value.compareTo(value) < 0){
			return insertHelper(cur.right, value);
		} else if (cur.value.compareTo(value) > 0){
			return insertHelper(cur.left, value);
		}
		throw new IllegalArgumentException();
	}
	
	public void insert(T value){
		root = insertHelper(root, value);
	}
	
	public boolean contains(T value){
		return contains(root, value); 
	}
	public boolean contains(Node<T> cur, T value){
		if (cur.value.equals(value)){
			return true;
		} else if (cur.value.compareTo(value) < 0){
			return contains(cur.right, value);
		} else if (cur.value.compareTo(value) > 0){
			return contains(cur.left, value);
		}
		return false;
	}
	
	public void remove(T value){
		root = remove(root, value);
	}
	
	private Node<T> remove(Node<T> cur, T value){
		if (cur.value.equals(value)){
			Node<T> newIndex = cur.right;
			while (cur.left != null)
				newIndex = newIndex.left;
			Node<T> newNode = new Node<T>(newIndex.value, cur.left, cur.right);
				
			if (newIndex.right != null){
				Node<T> newLeft = new Node<T>((T) newIndex.right.value);	
				newIndex = newLeft;			
			}
			return newNode;
		} else if (cur.value.compareTo(value) < 0){
			return remove(cur.right, value);
		} else if (cur.value.compareTo(value) > 0){
			return remove(cur.left, value);
		}
		throw new NoSuchElementException();
	}
}
