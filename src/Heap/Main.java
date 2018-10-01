package Heap;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		Heap obj=new Heap(16,0);
		obj.insert(15);
		obj.insert(4);
		obj.insert(17);
		obj.insert(8);
		obj.insert(3);
		obj.insert(10);
		obj.insert(55);
		obj.insert(12);
		obj.insert(13);
		obj.insert(1);
		obj.printHeap();
		Heap h=new Heap(16,0);
		int arr[]= {15,4,17,8,3,10,55,12,13,1};
		 System.out.println();
    	h.heapSort(arr);
//	    System.out.println(); System.out.println();
//		h.buildHeap(h, arr, arr.length);
//		System.out.println();
//		h.printHeap();System.out.println();
		System.out.println("arrays : "+Arrays.toString(arr));
		
	}

}
