package minHeap;

public class Main {

	public static void main(String[] args) throws Exception {
		MinHeap obj=new MinHeap(16, 1);
		obj.insert(15);
		obj.insert(11);
		obj.insert(13);
		obj.insert(19);
		obj.insert(35);
		obj.insert(1);
		obj.insert(29);
		obj.insert(2);
		obj.insert(131);
		obj.insert(193);
		obj.insert(32);
		obj.insert(10);
		obj.insert(9);
		obj.insert(3);
	System.out.println("max : "+obj.findMax());

	System.out.println(obj.searchElement(3));
	
		obj.printHeap();
		obj.delete(3);
		System.out.println();
		obj.printHeap();

	}

}
