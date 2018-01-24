package january_17_2018;

public class InterpolationSearch {
	public static void main(String[] args) {
		int pos, lo, hi, ele, arr[] = {1, 3, 5, 6, 7, 8, 99};
		lo = 0;
		hi = arr.length-1;
		ele = 15;
		while(lo <= hi && ele >=arr[lo] && ele <= arr[hi]) {
			pos = lo + ((ele-arr[lo])*(hi-lo))/(arr[hi]-arr[lo]);
			
			if(arr[pos] == ele) {
				System.out.println("element found");
				return;
			} else if(arr[pos] < ele) {
				lo = pos+1;
			} else {
				hi = pos-1;
			}
		}
		
		System.out.println("element not found");
	}
}