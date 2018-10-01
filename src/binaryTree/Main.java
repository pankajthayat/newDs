package binaryTree;

public class Main {

	public static void main(String[] args) throws Exception {
	
		BinaryTree obj=new BinaryTree();		
		obj.insertData(1);
		obj.insertData(2);
		obj.insertData(3);
		obj.insertData(4);
		obj.insertData(5);
		obj.insertData(6);
		obj.insertData(7);
		obj.insertData(8);
		obj.insertData(9);
		obj.insertData(10);
		obj.insertData(11);
		obj.insertData(12);
		obj.insertData(13);
    	obj.insertData(14);
    	System.out.println(obj.minDepth());
//System.out.println(obj.noOfLeafNode());
//System.out.println(obj.noOfLeafNodeRecursion(obj.root));
//	obj.inorder(obj.root);
//	System.out.println();
//	obj.preorderIterative();
	//	obj.inorderIterativeMyWay();
		
   //    obj.printZigZag();
//		obj.preorder(obj.root);System.out.println();
//		Node root=obj.mirrorImage(obj.root);
//		obj.preorder(root);
       
//		BinaryTree obj2=new BinaryTree();
//		obj2.insertData(10);
//		obj2.insertData(20);
//		obj2.insertData(30);
//		obj2.insertData(40);
//		obj2.insertData(50);
//		obj2.insertData(60);
//		obj2.insertData(70);
//
//		obj.rootToLeafPath(obj.root, "");
		
//	boolean x=obj.structurallySameOrNotMyWay(obj.root, obj2.root);
//		System.out.println(x);
//		System.out.println(obj.structurallySameOrNotRecusiveMyWay(obj.root, obj2.root));
		
		
		
		
		
		
		
		//to delete a given node
		/*Node toDelete=obj.search(obj.root, 5);
		Node preDeep=obj.preNodeOfDeepestNode();
		if(preDeep.right!=null)
		{
			toDelete.data=preDeep.right.data;
			preDeep.right=null;
		}
		else
		{
			toDelete.data=preDeep.left.data;
			preDeep.left=null;
		}*/ 
		
		
		
		
		
		

		
		
	}
}
