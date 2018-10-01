package binarySearchTree;

import java.util.Stack;

public class BinarySearchTree {
public Node root;
public BinarySearchTree() {
//	root=new Node();
}
public BinarySearchTree(int data) {
	root=new Node(data);
}


public void insert(int data)
{
	if(root==null)
		root=new Node(data);
	else
		insertHelper(root, data);
		
}
private void insertHelper(Node root,int data)
{
if(root!=null)
{
	if(root.data>=data&&root.left==null)
		root.left=new Node(data);
	else if(root.data<=data&&root.right==null)
		root.right=new Node(data);
	else if(root.data>=data)
	    insertHelper(root.left, data);
	else
		insertHelper(root.right, data);
		
}
}

public void inorder(Node root)
{
	if(root!=null)
	{
		inorder(root.left);
		System.out.print(root.data+" , ");
		inorder(root.right);
	}
}
public void inorderIterative(Node root)
{
	if(root==null)
		return;
	Stack<Node> s=new Stack();
	Node current=root;
	while(current!=null)
	{
		if(current.right!=null)
			s.push(current.right);
		s.push(current);
		current=current.left;
	}
	System.out.println(s);
	
}
public Node find(Node root,int data)
{
	if(root==null)
		return null;
	else
	{
		if(root.data==data)
			return root;
		else if(root.data>data)
			return find(root.left,data);
		else
			return find(root.right,data);
			
	}
}

public Node findMinimum(Node root)
{
	if(root==null)
		return null;
	else if(root.left==null)
		return root;
	else
		return findMinimum(root.left);
}
public Node findMinIterative()
{
 Node current=root;
 while(current.left!=null)
 {
	 current=current.left;
 }
 return current;
}

public Node findMaximim(Node root)
{
	if(root==null) return root;
	else if(root.right==null) return root;
	else return findMaximim(root.right);
}
public Node findMaxIterative()
{
	Node current=root;
	while(current.right!=null)
	{
		current=current.right;
	}
	return current;
}


public Node delete(Node root,int data)
{
	if(root==null)
	{
		System.out.println("1");
		return null;
	}
	Node current=root;
	Node pre=root;
	while(current!=null)
	{
		if(current.data==data)
			break;
		pre=current;
		if(current.data>data) current=current.left;
		else current=current.right;
	}
	if(current==null) 
		{
		System.out.println("2");
		return null;
		}
	
	if(current.left==null&&current.right==null)
	{
		if(pre.left==current) pre.left=null;
		else if(pre.right==current) pre.right=null;
		else 
			{
			System.out.println("3");
			root=null;
			}
	}
	else if(current.left!=null&&current.right!=null)
	{
		Node current2=current.left;
		Node pre2=current;
		while(current2.right!=null)
		{
			pre2=current2;
			current2=current2.right;
		}
		int temp=current.data; 
		current.data=current2.data;
		current2.data=temp;
		inorder(root);
//		System.out.println("data : "+data);
//		root =delete(root,data);
		if(pre2.left==current2)
			pre2.left=null;
		else
			pre2.right=null;
		
	}
	else
	{
		if(pre.left==current)
		{
			if(current.left==null)
				pre.left=current.right;
			else
				pre.left=current.left;
		}
		else if(pre.right==current)
		{
				if(current.left==null)
					pre.right=current.right;
				else
					pre.right=current.left;
		}
		else
		{
			if(root.left==null)
				root=root.right;
			else
				root=root.left;
		}
			
	}
	return root;
	
}


public boolean isBinary(Node root)
{
	if(root==null)
		return true;
	else
	{
		boolean h1=isBinary(root.left);
		boolean h2=isBinary(root.right);
		if(root.left!=null)
			h1=h1&&root.left.data<root.data;
		if(root.right!=null)
			h2=h2&&root.right.data>root.data;
			
		return h1&&h2;
	}
}



}


