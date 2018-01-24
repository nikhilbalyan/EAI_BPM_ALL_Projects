package january_08;

public class JumpSearch {

	public static int jump(int[] arr, int num) {
		int m = (int) Math.sqrt(arr.length);
		System.out.println(m);
		int index = 0;
		boolean flag = false;
		while (index < arr.length) {
			if (arr[index] == num) {
				return index;
			}

			if (arr[index] > num) {
				flag = true;
				break;
			}
			
			index = index + m;

		}

		if (flag) {
			index = index - m + 1;
			for (int i = index; i < index + m - 1; i++) {
				if (arr[i] == num) {
					return i;
				}
			}
		}
		
		index = index -m;
		if(index < arr.length-1) {
			for(int i = index; i < arr.length; i++) {
				if(arr[i] == num) {
					return i;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30 };
		int num = 30;
		int item = jump(arr, num);
		System.out.println(item);
	}
}
