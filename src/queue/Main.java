package queue;

public class Main {

	public static void main(String[] args) throws Exception {
		Queue obj=new Queue();
		obj.enQueue(new Demo(10));obj.enQueue(new Demo(20));obj.enQueue(new Demo(30));obj.enQueue(new Demo(40));
//		obj.enQueue(20);
//		obj.enQueue(30);
//		obj.enQueue(40);
//		obj.enQueue(50);
		System.out.println(obj);
		System.out.println(obj.deQueue());
//		System.out.println(obj.deQueue());
//		System.out.println(obj.front+"  rear : "+obj.rear);
		

	}

}
class Demo
{
	int a;int b;
	public Demo(int a) {
		this.a=a;
	}
	
	@Override
	public String toString() {
		
		return a+" ";
	}
}