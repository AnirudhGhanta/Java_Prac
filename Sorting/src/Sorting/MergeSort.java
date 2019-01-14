package Sorting;
import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class MergeSort<T extends Comparable<T>> {
	
	ArrayList<T> arr;
	
	public MergeSort() {
		arr = null;
	}

	private void mergSort(){
		mergeSort(arr, 0, arr.size()-1);
	}
	
	private void mergeSort(ArrayList<T> arr, int p, int r) {
		//if( (r-p+1) > 12 ) {
		if(p < r) {
			int q = (p+r)/2;
			
			mergeSort(arr, p, q);
			mergeSort(arr, q+1, r);
			merge(arr, p, q, r);
		}
		/*}
		else {
			insertionSort(arr, p, r);
		}*/
	}
	
	// we can do this Merge in multiple ways
	private void merge(ArrayList<T> arr, int p, int q, int r) {
		// we assume that in array arr, p to q are sorted and q+1 to r are sorted.
		int n1 = q-p+1;
		int n2 = r-q;
		
		// lets get two temp arraylists to hold the value while we merge
		ArrayList<T> Larr = new ArrayList<T>();
		ArrayList<T> Rarr = new ArrayList<T>();
		for(int i = 1; i <= n1; i++) {
			Larr.add(arr.get(p+i-1));
		}
		for(int i = 1; i <= n2; i++) {
			Rarr.add(arr.get(q+i));
		}
		
		int i = 0;
		int j = 0;
		int k = p;
		while( i<n1 && j<n2) {
			if(Larr.get(i).compareTo(Rarr.get(j)) <= 0) {
				arr.set(k, Larr.get(i));
				i++;
			}
			else {
				arr.set(k, Rarr.get(j));
				j++;
			}
			k++;
		}
		
		//copy remaining elements of L and R if any
		while( i < n1) {
			arr.set(k, Larr.get(i));
			i++;
			k++;
		}
		
		while( j < n2) {
			arr.set(k, Rarr.get(j));
			j++;
			k++;
		}
	}

	public void insertionSort(ArrayList<T> arr, int p, int r) {
		// TODO Auto-generated method stub
	}

	private void print() {
		int s = arr.size();
		for(int i = 0; i < s; i++) {
			System.out.println(arr.get(i));
		}
	}
	public static void main(String args[]) {
		MergeSort<Integer> int_mgst = new MergeSort<Integer>();
		int_mgst.arr = new ArrayList<Integer>();
		int_mgst.arr.add(4);
		int_mgst.arr.add(5);
		int_mgst.arr.add(6);
		int_mgst.arr.add(3);
		int_mgst.arr.add(25);
		int_mgst.arr.add(12);
		int_mgst.arr.add(41);
		int_mgst.arr.add(1);
		int_mgst.arr.add(7);
		int_mgst.arr.add(2);
		
		
		
		int_mgst.print();
		System.out.println("sorting");
		int_mgst.mergSort();
		int_mgst.print();
		
		
		MergeSort<String> str_mgst = new MergeSort<String>();
		str_mgst.arr = new ArrayList<String>();
		str_mgst.arr.add("sfd");
		str_mgst.arr.add("hgf");
		str_mgst.arr.add("tds");
		str_mgst.arr.add("gfd");
		str_mgst.arr.add("avc");
		str_mgst.arr.add("acf");
		str_mgst.arr.add("bgd");
		str_mgst.arr.add("bnh");
		
		str_mgst.mergSort();
		str_mgst.print();
	}
}
