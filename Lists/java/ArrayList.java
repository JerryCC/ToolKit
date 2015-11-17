import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayList<T> implements Lists<T>{

	private int size;
	private int capacity;
	private T[] datas;
	
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity){
		datas = (T[]) new Object[capacity];
		size = 0;
	}
	
	public ArrayList(){
		this(10);
	}
	
	public void add(T data) {
		if(size == capacity)
			expande();
		datas[size++] = data;
	}

	@SuppressWarnings("unchecked")
	private void expande(){
		T[] newDatas = (T[]) new Object[capacity * 2];
		newDatas = Arrays.copyOf(datas, capacity * 2);
		datas = newDatas;
	}
	

	public void insert(T data, int index) {
		if (size++ > capacity)
			expande();
		for (int i = size - 1; i > index; i--)
			datas[i] = datas[i - 1];
		datas[index] = data;
	}
	
	
	public void remove(int index) {
		for (int i = index; i < size - 1; i++)
			datas[i] = datas[i+1];
		size--;
	}

	public T get(int index) {
		return datas[index];
	}

	public void set(int index, T data) {
		if(index >= capacity){
			throw new IndexOutOfBoundsException();
		}else{
			datas[index] = data;
		}
	}

	public void clean() {
		size = 0;
	}

	public boolean contains(T data) {
		for (T t : datas){
			if (t.equals(data))
				return true;
		}
		return false;
	}

	public int indexOf(T data) {
		int counter = 0;
		for (T t : datas){
			if (t.equals(data))
				return counter;
			counter++;
		}
		throw new NoSuchElementException();
	}

	public int getSize() {
		return size;
	}	
}