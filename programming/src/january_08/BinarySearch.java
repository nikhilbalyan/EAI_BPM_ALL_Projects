package january_08;

public class BinarySearch {
	
	public static int binarySearch(int arr[], int n) {
		int right = arr.length-1;
		int left = 0;
		int mid = 0;
		
		while (left <= right) {
			System.out.println("loop phas gayi");
			
			mid = left + (right-left)/2;
			if(arr[mid] == n) 
				return mid;
			
			else if(arr[mid] < n) {
				left = mid;
			} else {
				right = mid;
			}
		}
		
		
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr =  { 1, 2, 3, 4, 5, 6};
		int n = 1;
		int size = binarySearch(arr, n);
		System.out.println(size);
	}
}