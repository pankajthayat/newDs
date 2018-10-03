package binaryTree;

import java.util.LinkedList;
//import java.util.Queue;
import java.util.Stack;

import queue.Queue;

public class BinaryTree {
Node root;
Node current;
Queue queue;
public BinaryTree() {
	queue=new Queue();
}

public void insertData(int data) throws Exception
{
	Node node=new Node(data);
if(current==null)
{
	current=node;
	root=current;
}
else if(current.left==null)
{
current.left=node;
queue.enQueue(current.left);
}
else if(current.right==null)
{
	current.right=node;
	queue.enQueue(current.right);
}

else
{
	//System.out.println("current : "+current+ "  data : "+current.data);
	current=(Node)queue.deQueue();
	insertData(data);
}

}
public void preorder(Node root)
{
	if(root!=null)
	{
		System.out.print(root.data+" , ");
		preorder(root.left);
		preorder(root.right);
	}
}
public void preorderIterative()
{
	Node current =root;
	Stack<Node> stack=new Stack();
	while(current!=null)
	{
		System.out.print(current.data+" , ");
		if(current.right!=null)
		stack.push(current.right);
		//System.out.println(stack);
		try {
		current=current.left!=null?current.left:stack.pop();
		}
		catch(Exception e)
		{
			current=null;
		}
		//System.out.println(stack);
		//System.out.println("cur: "+current);
	}
}
public void postorderIterative()
{
	Stack<Node> s=new Stack(); Node current=root; Node pre=null;
	do
	{
		if(current!=null)
		{
			s.push(current);
			if(current.right!=null) s.push(current.right);
		}
		else
		{
			Node temp=s.pop();
			if(temp.right!=null&&temp.right!=pre)
			{
				s.push(temp);
				s.push(temp.right);
				current=temp;
			}
			else
			{
				System.out.print(temp.data+" , ");
				pre=temp;
			}
		}
		if(current!=null) current=current.left;
	}while(!s.isEmpty());
}

public void postorder(Node root)
{
	if(root!=null)
	{
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" , ");
	}
}

public int maxIntInterative()
{
	Stack<Node> stack=new Stack();
	stack.push(root);
	int max=Integer.MIN_VALUE;
	while(!stack.isEmpty())
	{
		Node temp=stack.pop();
		if(max<temp.data)
			max=temp.data;
		if(temp.right!=null)
		stack.push(temp.right);
		if(temp.left!=null)
		stack.push(temp.left);
	}
	return max;
}

public int maxIntRecursive()
{
	return maxIntHelper(root,Integer.MIN_VALUE);
}
public int maxIntHelper(Node root,int max)
{
	if(root==null)
		return max;
	else
	{
		int leftValue=maxIntHelper(root.left, max);
		int rightValue=maxIntHelper(root.right, max);
		max=leftValue>rightValue?leftValue:rightValue;
		max=root.data>max?root.data:max;
	}
	return max;
}


public int sizeOfTree()
{
	Stack stack=new Stack();
	stack.push(root);
	int count=0;
	while(!stack.isEmpty())
	{
		Node temp=(Node)stack.pop();
		if(temp.right!=null)
		stack.push(temp.right);
		if(temp.left!=null)
		stack.push(temp.left);
		count++;
	}
	return count;
}

public int sizeOfTreeRecursive(Node root)
{
	/*if(root==null)
		return 0;
	else {
		int leftCount=sizeOfTreeRecursive(root.left);
		int rightCount=sizeOfTreeRecursive(root.right);
		int size=leftCount+rightCount+1;
		return size;
	}*/
	int leftCount=root.left==null?0:sizeOfTreeRecursive(root.left);
	int rightCount=root.right==null?0:sizeOfTreeRecursive(root.right);
	int size=leftCount+rightCount+1;
	return size;
}

public int heightOfBinaryTree()
{
	return heightHepler(root, -1, 0);
}
private int heightHepler(Node root,int x,int height)
{
	if(root==null)
		return x>height?x:height;
		else
		{
			x++;
			height=heightHepler(root.left, x, height);
			height=heightHepler(root.right, x, height);
			return height;
		}
}

public void heightOf_BT_Demo()
{
	Stack s=new Stack();
	Object[] arr= {root,0};
	s.push(arr);
	//s.push({0,1}) why is it wrong?
	System.out.println(s.pop());
	while(s.isEmpty())
	{
		Object[] temp=(Object[])s.pop();
		Node x=(Node)temp[0];
		if(x.right!=null)
		{
			Object[] temp2= {x.right,((Integer)temp[1])+1};
			s.push(temp2);
		}
		
		
	}
	
}


public void insertMyWay(int data)
{
	Node node=new Node(data);
	if(root==null)
	{
		root=node;
		return;
	}
	java.util.Queue<Node> q=new LinkedList();
	Node current=root;
	while(current!=null)
	{
		if(current.left==null)
		{
			current.left=node;
			return;
		}
		if(current.right==null)
		{
			current.right=node;
			return;
		}
		q.offer(current.left);
		q.offer(current.right);
		current=q.poll();
	}
	
}

public int heightMyWay(Node root,int x)
{
	if(root==null)
		return x;
	else
	{
		x=x+1;
		int h1=heightMyWay(root.left,x);
		int h2=heightMyWay(root.right, x);
		return h1>h2?h1:h2;
	}
}

public Node heigthByIteration()
{
	if(root==null)
		return null;
	int h=0;
	Node pre=null;
	Node curr=null;
	Stack s=new Stack();
	s.push(root);
	Node deepestNode =null;
	while(!s.isEmpty())
	{
		curr=(Node)s.peek();
		if(pre==null||pre.left==curr||pre.right==curr)
		{
			if(curr.left!=null)
				s.push(curr.left);
			else if(curr.right!=null)
				s.push(curr.right);
		}
		else if(curr.left==pre)
		{
			if(curr.right!=null)
				s.push(curr.right);
		}
		else
		{
			if(h<=s.size())
			{
				h=s.size();
				deepestNode=(Node)s.peek();
			}
			s.pop();
			//System.out.println("kskldj");
		}
		pre=curr;
	}
	//return h;
	return deepestNode;
}

public Node search(Node root,int element)
{
	if(root==null||root.data==element)
		return root;
	else
	{
		Node n1=search(root.left, element);
		if(n1!=null)
			return n1;
		Node n2=search(root.right, element);
		if(n2!=null)
			return n2;
		return n2;
	}
}
public Node preNodeOfDeepestNode()
{
	if(root==null)
		return null;
	int h=0;
	Node pre=null;
	Node curr=null;
	Stack<Node> s=new Stack();
	s.push(root);
	Node deepestNode =null;
	Node preDeepestNode=null;
	while(!s.isEmpty())
	{
		curr=(Node)s.peek();
		if(pre==null||pre.left==curr||pre.right==curr)
		{
			if(curr.left!=null)
				s.push(curr.left);
			else if(curr.right!=null)
				s.push(curr.right);
		}
		else if(curr.left==pre)
		{
			if(curr.right!=null)
				s.push(curr.right);
		}
		else
		{
			if(h<=s.size())
			{
				Node temp=s.pop();
				preDeepestNode=s.peek();
				s.push(temp);
				h=s.size();
				deepestNode=(Node)s.peek();
			}
			s.pop();
			//System.out.println("kskldj");
		}
		pre=curr;
	}
	//return h;
	return preDeepestNode;
}

public String noOfLeafNode()
{
	if(root==null)
		return 0+"";
	java.util.Queue<Node> q=new LinkedList();
	q.offer(root); q.offer(null);
	int count=0,level=0;
	while(!q.isEmpty())
	{
		Node temp=q.poll();
		if(temp==null)
		{
			level++;
			if(!q.isEmpty())
			q.offer(null);
		}
		else if(temp.left==null&&temp.right==null)
			count++;
		else 
			{
			if(temp.left!=null)
			q.offer(temp.left);
		    if(temp.right!=null)
			q.offer(temp.right);
	      }
	
	}
	return "Count : "+count+"  level : "+level;
}
public int noOfLeafNodeRecursion(Node root)
{
	if(root==null) return 0;
	else
	{
		int h1=noOfLeafNodeRecursion(root.left);
		int h2=noOfLeafNodeRecursion(root.right);
		if(root.left==null&&root.right==null) return h1+h1+1;
		else return h1+h2+0;
	}
}

public int noOfFullNode()
{
	if(root==null)
		return 0;
	Stack<Node> s=new Stack();
	s.push(root);
	int count=0;
	while(!s.isEmpty())
	{
		Node temp=s.pop();
		System.out.print(temp.data+" , ");
		if(temp.left!=null&&temp.right!=null)
			count++;
		if(temp.right!=null)
			s.push(temp.right);
		if(temp.left!=null)
			s.push(temp.left);
		
	
	}
	return count;
}

//checking if rigth and left of both the tree is same(null or not null) at evenry point
public boolean structurallySameOrNotMyWay(Node root1,Node root2)
{
	if(root1==null&&root2==null)
		return true;
	else if(root1!=null&&root2!=null)
	{
		Stack<Node> s1,s2;s1=new Stack<>(); s2=new Stack();
		s1.push(root1);s2.push(root2);
		boolean flag=true;
		while(!s1.isEmpty()&&!s2.isEmpty())
		{
			int x1=99,y1=88,x2=12,y2=32;
			Node temp1=s1.pop();Node temp2=s2.pop();
			if(temp1.right!=null)
			{
				s1.push(temp1.right); x1=0;
			}
			else
			x1=1;
			if(temp1.left!=null)
			{
				s1.push(temp1.left);y1=0;
			}
			else
				y1=1;
			if(temp2.right!=null)
			{
				s2.push(temp2.right); x2=0;
			}
			else
				x2=1;
			if(temp2.left!=null)
			{
				s2.push(temp2.left);y2=0;
			}
			else y2=1;
			
			if(x1==x2&&y1==y2)
				flag=flag&&true;
			else
				flag=false;
		}
		if(!(s1.isEmpty()&&s2.isEmpty()))
		{
			//System.out.println("snkdjl");
			return false;
		}
		System.out.println("pankaj");
		return flag;
		
	}
	else
		return false;
}

public boolean structurallySameOrNotRecusiveMyWay(Node root1,Node root2)
{
	if(root1==null&&root2==null)
		return true;
	else if(root1!=null&&root2!=null)
	{
		boolean x=structurallySameOrNotRecusiveMyWay(root1.left, root2.left);
		if(x==false) return false;
		boolean y=structurallySameOrNotRecusiveMyWay(root1.right, root2.right);
		if(y==false) return false;
		return x&&y;
		
	}
	else
		return false;
}


public void rootToLeafPath(Node root,String h)
{
	if(root==null)
		return;
	if(root.left==null&&root.right==null)
	{
		System.out.println("path : "+h+root.data);
	}
	else
	{
		h=h+root.data+" ";
		rootToLeafPath(root.left,h);
		rootToLeafPath(root.right,h);
	}
}


public Node mirrorImage(Node root)
{
	if(root==null)
		return root;
	else
	{
		Node r1=mirrorImage(root.left);
		Node r2=mirrorImage(root.right);
		root.left=r2;
		root.right=r1;
		return root;
	}
	
}

public boolean isMirrorImage(Node root1,Node root2)
{
	if(root1==null&&root2==null)
		return true;
	else if(root1!=null&&root2!=null)
	{
		boolean h1=isMirrorImage(root1.left, root2.right);
		if(root1.data==root2.data)
			h1=h1&&true;
		else
			return false;
		boolean h2=isMirrorImage(root1.right, root2.left);
		if(root1.data==root2.data)
			h1=h1&&true;
		else
			return false;
		return h1&&h2;
		
	}
	else
		return false;
}

public void printZigZag()
{
	if(root==null) {
		System.out.println("Tree is empty");
		return;
	}
	Stack<Node> s1=new Stack();
	Stack<Node> s2=new Stack();
	s1.push(root);
	int flag=0;
	while(!s1.isEmpty()||!s2.isEmpty())
	{
		Node temp;
		if(flag==0)
		{
			temp=s1.pop();
			if(temp.left!=null) s2.push(temp.left);
			if(temp.right!=null) s2.push(temp.right);
		}
		else
		{
			temp=s2.pop();
			if(temp.right!=null) s1.push(temp.right);
			if(temp.left!=null)  s1.push(temp.left);
		}
		if(s1.isEmpty())
			flag=1;
		if(s2.isEmpty())
			flag=0;
		System.out.print(temp.data+" , ");
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
public void inorderIterativeMyWay()
{
	Stack<Node> s=new Stack();
	int flag=0; Node current=root;
	do
	{
		if(flag==0)
			s.push(current);
		if(current==null||flag==1)
		{
			Node temp=s.pop();
			System.out.print(temp.data+" , ");
			if(temp.right!=null)
			{
				s.push(temp.right);
				current=temp.right;
				flag=0;
			}
		}
		if(flag==0)
			current=current.left;
		if(current==null)
			flag=1;
	}while(!s.isEmpty());
}

public int minDepth()
{
	java.util.Queue<Node> q=new LinkedList();
	q.offer(root); q.offer(null);
	int level=-1;int depth=0;
	while(!q.isEmpty())
	{
		Node temp=q.poll();
		if(temp==null) level++;
		if(temp==null&&!q.isEmpty())
		{
			q.offer(null);
		}
		else {
			if(temp.left!=null) q.offer(temp.left);
			if(temp.right!=null) q.offer(temp.right);
			if(temp.left==null&&temp.right==null)
				return level+1;//depth=level+1;
		}
	}
	return -1;
}

}
