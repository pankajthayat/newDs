package minHeap;

public class MinHeap {
public int arr[];
public int count;
public int capacity;
public int type;
public MinHeap(int capacity,int type) {
	arr=new int[capacity];
	this.capacity=capacity;
	this.type=type;
}
public int leftChild(int i)
{
	if(i<0) return -1;
	int left=(2*i+1);
	return left<count?left:-1;
}
public int rightChild(int i)
{
	if(i<0||i>=count) return -1;
	int rigth=(2*i+2);
    return rigth<count?rigth:-1;
}
public int parent(int i)
{
	if(i<=0||i>=capacity) return -1;
	int parent=(i-1)/2;
	return parent;
}
public int getMin()
{
	return this.count==0?-1:arr[0];
}

public void percolateDown(int i)
{
	int l=leftChild(i); int r=rightChild(i);
	int min=-1;
	if(l!=-1)
	{
		min=arr[i]>arr[l]?l:i;
	}
	if(r!=-1)
	{
		min=arr[min]<arr[r]?min:r;
	}
	if(min!=-1&&min!=i)
	{
		int temp=arr[i];
		arr[i]=arr[min];
		arr[min]=temp;
		percolateDown(min);
	}
}

public void percolateUp(int i)
{
	int p=parent(i);
	//System.out.println("parent : "+p);
	if(p!=-1)
	{
		if(arr[p]>arr[i])
		{
			int temp=arr[i];
			arr[i]=arr[p];
			arr[p]=temp;
			percolateUp(p);
		}
	}
}

public void insert(int data) throws Exception
{
	//System.out.println("count : "+count+"  capacity : "+capacity);
	if(count>=capacity)
		throw new Exception("Heap is full ");
	arr[count]=data;
	percolateUp(count);
	count++;
}

public int findMaxi(int i)//wrong
{
	int l=leftChild(i); int r=rightChild(i);
	int max=i;
	if(l!=-1)
	{
		max=arr[l]>arr[max]?l:max;
	}
	if(r!=-1)
	{
		max=arr[r]>arr[max]?r:max;
	}
	if(max==i) return arr[max];
	else return findMaxi(max);
}

public int findMax2ndWay(int i)//wrong
{
	int l=leftChild(i); int r=rightChild(i);
	if(l==-1&&r==-1) return arr[i];
	else if(r==-1) return arr[l];
	else return findMax2ndWay(l>r?l:r);
}
public int findMax()
{
	int parent=parent(count-1);
	int max=arr[parent];
	for(int i=parent+1;i<count;i++)
	{
		max=arr[i]>max?arr[i]:max;
	}
	return max;
}

public int searchElement(int data)
{
	for(int i=0;i<count;i++)
	{
		if(arr[i]==data) return i;
	}
	return -1;
}
public void delete(int data)
{
	int i=searchElement(data);
	if(i!=-1)
	{
	int t=arr[i];
	arr[i]=arr[count-1];
	arr[count-1]=t;
	count=count-1;
	percolateDown(i);
	}
}
public void printHeap()
{
	for(int i=0;i<count;i++)
		System.out.print(arr[i]+" , ");
}
}
