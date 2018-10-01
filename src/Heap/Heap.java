package Heap;

import java.util.Arrays;

public class Heap {
public int [] arr;
public int count;
public int capacity;
public int heapType;
public Heap(int capacity,int heapType) {
	this.capacity=capacity; 
	this.heapType=heapType;
	this.arr=new int[capacity];
}
public int LeftChild(int i)
{
	int x=2*i+1;
	if(x>=count)
		return -1;
	return x;
}
public int rightChild(int i)
{
	int right=2*i+2;
	if(right>=count)
		return -1;
	return right;
}
public int parent(int i)
{
	
	if(i<=0||i>=capacity)
		return -1;
	return (i-1)/2;
}
public int getMax()
{
	if(this.count==0) return -1;
	return arr[0];
}

public void insert(int data)
{
	if(count>capacity)
		System.out.println("heap is full");
	else
	{
		arr[count]=data;
//		System.out.println(arr[count]);
		percolateUp(count);
		count++;
	}
}
public void percolateUp(int i)
{
	if(i>0)
	{
	//	System.out.println("i "+i+"  "+parent(i));
		if(arr[i]>arr[parent(i)])
		{
			int temp=arr[i];
			arr[i]=arr[parent(i)];
			arr[parent(i)]=temp;
			percolateUp(parent(i));
		}
	}
}
public void percolateDown(int i)
{
	if(i!=-1)
	{
		int max=-1;
		int left=LeftChild(i); int right=rightChild(i);
		if(left!=-1)
		{
			max=arr[left]>arr[i]?left:i; 
		}
		if(right!=-1)
		{
			max=arr[right]>arr[max]?right:max;
		}
		if(max!=-1&&max!=i)
		{
		int temp=arr[max];arr[max]=arr[i];arr[i]=temp;
		percolateDown(max);
		}
		
		
	}
}
public void deleteMax()
{
	int temp=arr[0]; arr[0]=arr[count-1];arr[count-1]=temp;
	count--;
	percolateDown(0);
}

public void buildHeap(Heap h,int[] arr,int n)
{
	
	if(h==null) return;
	h.arr=arr;
	h.count=n;
	for(int i=parent(h.count-1);i>=0;i--)
	{
		percolateDown(i);
	}
}

public void heapSort(int[]arr)
{//int arr[]= {15,4,17,8,3,10,55,12,13,1};
	Heap y=new Heap(16,0);
	y.buildHeap(y, arr, arr.length);
//	int x=y.count;
	//y.printHeap();
	System.out.println();
	System.out.println("aa  "+Arrays.toString(arr));
	while(y.count>0)
	{
		int temp=arr[0];arr[0]=arr[y.count-1];arr[y.count-1]=temp;
		y.count--;
		y.percolateDown(0);
		
	}
	System.out.println("aa  "+Arrays.toString(arr));
}


public void printHeap()
{
	for(int i=0;i<count;i++)
		System.out.print(arr[i]+ " , ");
}

}
