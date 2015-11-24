import java.util.Arrays;

public class HeapSort<T extends Comparable<T>> {

	private int n;
	
	private void buildHeap(T[] input){ 
		n = input.length - 1;
		for (int i = n/2; i >= 0; i-- ){
			heapify(input, i);
		}
	}
	
	private void heapify(T[] input, int index){
		int left = 2 * index ;
		int right = 2 * index + 1;
		int largest = index;
		//if (left < input.length && right < input.length){
			if(left <= n && input[left].compareTo(input[largest]) > 0)
				largest = left;
			if(right <= n && input[right].compareTo(input[largest]) > 0)
				largest = right;
		
		if (largest != index){
			T temp = input[index];
			input[index] = input[largest];
			input[largest] = temp;
			heapify(input, largest);
		}
	}

	public void heapSort(T[] input){
		buildHeap(input);
		for (int i = n; i >= 0; i--){
			T temp = input[i];
			input[i] = input[0];
			input[0] = temp;
			n--;
			heapify(input, 0);
		}
	}
	
	public static void main(String[] args){
		Integer[] arr = {4,12,2,4,5,6,21,34,6,7,2,1,0};
		System.out.println(arr.length);
		HeapSort<Integer> heap = new HeapSort<>();
		heap.heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
