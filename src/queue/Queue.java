package queue;

public class Queue {
public Object data;
public int front=0;
public int rear=0;
public int capacity=32;
public Object arr[];
public Queue() {
	arr=new Object[capacity];
}
public void enQueue(Object data) throws Exception
{
	if(rear>=capacity)
		throw new Exception("Queue Overflow");
	arr[rear]=data;
	rear++;
}

public Object deQueue() throws Exception
{
	if(rear-front==0)
		throw new Exception("queue is empty");
	Object data=arr[front];
    front++;
    return data;
}

@Override
	public String toString() {
		String result="{ ";
		for(int i=front;i<rear;i++)
		{
			result=result+arr[i]+" , ";
		}
		return result+" }";
	}

}
