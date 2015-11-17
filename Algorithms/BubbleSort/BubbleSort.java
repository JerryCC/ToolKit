public class BubbleSort<T>{
	public <T extends Comparable<T>> void bubbleSort(T[] arr){
		for (int i = 0; i < arr.length; i++){
			for (int j = i; j < arr.length; j++){
				if(arr[j].compareTo(arr[j+1]) > 0){
					T temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}