import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class SelectionSort {
	public static Comparable[] a;
	
	private SelectionSort()
	{
		
	}
	
	public boolean less(Comparable a, Comparable b)
	{
		return(a.compareTo(b)<0);
	}
	
	public void exchange(Comparable[] a, int i, int j)
	{
		Comparable swap=a[i];
		a[i]=a[j];
		a[j]=swap;
		
	}
	public void sort(Comparable[] a)
	{
		int N= a.length;
		for(int i=0;i<N;i++)
		{
			int min = i;
			for(int j=i+1;j<N;j++)
			{
				if(less(a[j],a[min]))min=j;
			}
			exchange(a,i,min);
		}
	}
	
	public void display()
	{
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		SelectionSort s= new SelectionSort();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the string to be sorted");
		String input=br.readLine();
		a=input.split(" ");
		s.sort(a);
		s.display();
	}
	
	
}
