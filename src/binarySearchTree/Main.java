package binarySearchTree;

public class Main {

	public static void main(String[] args) {
	BinarySearchTree obj=new BinarySearchTree();
	obj.insert(15);
	obj.insert(12);
	obj.insert(20);
	obj.insert(17);
	obj.insert(16);
	obj.insert(10);
	obj.insert(13);
	obj.insert(67);
	obj.insert(220);
	obj.insert(100);
	obj.insert(1);
	obj.insert(2);

	System.out.println("isBinary : "+obj.isBinary(obj.root));
	//obj.inorderIterative(obj.root); implememt it
//	System.out.println(obj.findMaximim(obj.root).data);
//	System.out.println(obj.findMaxIterative().data);
//	System.out.println(obj.findMinimum(obj.root).data);
//	System.out.println(obj.findMinIterative().data);
//	Node root=obj.delete(obj.root,20);
//	System.out.println("root : "+root);
//	obj.inorder(root);
	
	
	}
}
