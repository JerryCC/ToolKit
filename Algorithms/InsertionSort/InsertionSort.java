public class InsertionSort<T>{

	public <T extends Comparable<T>> void insertionSort(T[] arr){
		for (int i = 0; i < arr.length; i++){
			for (int j = arr.length - 1; j >= i; j--){
				if (arr[j].compareTo(arr[j-1]) < 0){
					T temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
	}

}