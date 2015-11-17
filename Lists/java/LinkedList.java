import java.util.NoSuchElementException;

public class LinkedList<T> implements Lists<T>{

	public class Node<T>{
		private T data;
		private Node next;

		public Node(T data, Node next){
			this.data = data;
			this.next = next;
		}

		public Node(T data){
			this(data, null);
		}
	}

	private Node<T> first;

	public LinkedLists(T data){this.first = new Node(data);}
	
	public void add(T data){
		if (first == null){
			first = new Node(data);
		}
		else {
			Node<T> cur = first;
			while (cur.next != null)
				cur = cur.next;
			cur.next = new Node<T>(data);
		}
	}
	

	public void remove(int index) {
		if (index >= getSize()){
			throw new IndexOutOfBoundsException();
		}else if(index == 0){
			//I don't need to check whether first.next is null or not.
			//if it does, this would clean the whole list, which is what I wnat.
			first = first.next;
		}else if(index == 1){
			//same reason applies to here.
			first.next = first.next.next;
		}else{
			Node cur = first.next;
			Node pre = first;
			int counter = 0;
			while (cur.next != null){
				if (counter++ == index){
					pre.next = cur.next;
					return;
				}else{
					pre = cur;
					cur = cur.next;
				}
			}
		}
	}

	public void insert(T data, int index) {
		if (index >= getSize()){
			throw new IndexOutOfBoundsException();
		}else if (index == 0){
			first.data = data;
		}else if (index == 1){
			first.next.data = data;
		}else{
			Node cur = first.next;
			Node pre = first;
			int counter = 0;
			Node newNode = new Node<T>(data);
			while (cur.next != null){
				if (counter++ == index){
					pre.next = newNode;
					newNode.next = cur;
					return;
				}else{
					pre = cur;
					cur = cur.next;
				}
			}
		}
	}
	
	public T get(int index){
		if (index > getSize())
			throw new IndexOutOfBoundsException();
		int counter = 0;
		Node cur = first;
		while (counter++ != index)
			cur = cur.next;	

		if (counter == index)
			return (T) cur.data;
		else 
			throw new IndexOutOfBoundsException();
		
	}
	
	public void set(int index, T data){
		int counter = 0;
		Node cur = first;
		while (counter++ != index){
			cur = cur.next;
		}
		if (counter == index)
			cur.data = data;
		else 
			throw new IndexOutOfBoundsException();
	}
	
	public void clean(){
		this.first = null;
	}
	
	public boolean contains(T data){
		Node<T> cur = first;
		while (cur != null){
			if (cur.data.equals(data))
				return true;
			cur = cur.next;
		}	
		return false;
	}

	public int indexOf(T data){
		int index = 0;
		Node<T> cur = first;
		while (cur != null){
			if (cur.data.equals(data))
				return index;
			cur = cur.next;
			index++;
		}	
		throw new NoSuchElementException();
	}

	public int getSize(){
		if (first == null)
			return 0;
		Node<T> cur = first;
		int counter = 1;
		while (cur.next != null){
			counter++;
			cur = cur.next;
		}
		return counter;
	}



}
