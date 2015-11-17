public class SelectionSort<T>{
	public <T extends Comparable<T>> void selectionSort(T[] arr){
		for (int i = 0; i < arr.length; i++){
			int min = i;
			for (int j = i; j < arr.length; j++){
				if (arr[min].compareTo(arr[j]) > 0)
					min = j;
			}
			T temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
}