import java.util.*;
import java.io.*;
public class MergeSort {
	private MergeSort()
	{
		
	}
	
	public static Comparable[] a;
	
	public void sort(Comparable[] a,int low, int high)
	{
		if(high<=low)
			return;
		int mid= low+(high-low)/2;
		sort(a,low,mid);
		sort(a,mid+1,high);
		merge(a,low,mid,high);
	}

	public void merge(Comparable[] a,int low, int mid, int high)
	{
		Comparable[] aux= new Comparable[a.length];
		for(int i=low;i<=high;i++)
		{
		 aux[i]=a[i];
		}
		int i=low,j=mid+1;
		for(int k=low;k<=high;k++)
		{
			if(i>mid) a[k]=aux[j++];
			else if(j>high) a[k]=aux[i++];
			else if(less(aux[j],aux[i])) a[k]=aux[j++];
			else 				a[k]=aux[i++];
		}
	}

	public boolean less(Comparable a, Comparable b)
	{
		return (a.compareTo(b)<0);
	}
	
	public void display(Comparable[] a)
	{
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		MergeSort m= new MergeSort();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the elements to be sorted");
		Comparable[] a= br.readLine().split(" ");
		m.sort(a,0,a.length-1);
		m.display(a);
	}
}
