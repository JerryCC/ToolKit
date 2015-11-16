public interface Lists<T>{
	public void add(T data);
	public void remove(int index);
	public void get(int index);
	public void set(int index, T data);
	public void clean():
	public void contains(T data);
	public void indexOf(T data):
	public void getSize();
	public void insert(T data, int index);
}