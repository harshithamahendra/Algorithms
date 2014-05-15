import java.io.*;
public class Quicksort {
	static Comparable[] array;
	public static void main(String[] args) throws IOException{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the numbers to be sorted");
		String input = br.readLine();
		array = input.split(" ");
		sort(array, 0, array.length - 1);
		System.out.println("Sorted array:");
		for(Comparable a: array){
			System.out.print(a + " ");
		}
	}

	public static void sort(Comparable[] a,int low,int high){
		if(low >= high)
			return;
		int k = partition(a,low,high);
		sort(a,low, k - 1);
		sort(a,k + 1,high);
	}

	public static int partition(Comparable[] a,int low,int high){
		int i = low + 1;
		int j = high;
		while(true){
			while(a[i].compareTo(a[low]) < 0){
				if(i >= high)
					break;
				i++;
			}

			while(a[j].compareTo(a[low]) > 0 ){
				if(j <= low)
					break;
				j--;
			}
			if(i >= j)
				break;
			exchange(a,i,j);
		}
		exchange(a,low,j);
		return j;
	}
	public static void exchange(Comparable[] a, int i, int j){
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
