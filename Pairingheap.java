package Heaps;

import java.util.ArrayList;

public class Pairingheap<T extends Comparable<T>> {
	int size;
	PNode root;
	ArrayList<PNode> children;

	class PNode {
		T data;
		PNode child;
		PNode rightSibling;
		PNode LeftSibling;

		PNode(T x) {
			this.data = x;
			this.child = null;
			this.rightSibling = null;
			this.LeftSibling = null;
		}
	}

	public Pairingheap() {
		root = null;
		children = new ArrayList<PNode>();
	}

	public T findMin(PNode root) {
		if (root == null) {
			return null;
		}

		else
			return root.data;

	}

	public boolean IsEmpty() {
		if (root == null) {
			return true;
		} else
			return false;
	}

	public void makeEmpty() {
		root = null;
	}

	public void push(T x) {
		PNode n = new PNode(x);
		size++;
		if (root == null) {
			root = n;
		} else {
			root = merge(root, n);
		}

	}

	PNode merge(PNode heap1, PNode heap2) {
		if (heap1 == null) {
			return heap2;
		}

		else if (heap2 == null) {
			return heap1;
		}

		if (heap1.data.compareTo(heap2.data) < 0) {
			heap2.LeftSibling = heap1.LeftSibling;
			heap1.LeftSibling = heap2;
			heap1.rightSibling = heap2.child;

			if (heap1.rightSibling != null) {
				heap1.rightSibling.LeftSibling = heap1;
			}

			heap2.child = heap1;
			return heap2;
		}

		else {
			heap2.LeftSibling = heap1;
			heap1.rightSibling = heap2.rightSibling;
			if (heap1.rightSibling != null) {
				heap1.rightSibling.LeftSibling = heap1;
			}
			heap2.rightSibling = heap1.child;
			if (heap2.rightSibling != null) {
				heap2.rightSibling.LeftSibling = heap2;
			}
			heap1.child = heap2;
			return heap1;
		}
	}







	public T pop()
	{  T data = root.data;
	
	if(root.child == null)
	{
		return root.data;
	}
	root = combineSibling(root.child);



	return data;
	}
	
	
	
	
	public PNode combineSibling(PNode node)
	{
		if(node.rightSibling == null)
		{
			return node;
		}
		
		
		int countSibling = 0 ;
		
		for( ; node!= null ; countSibling++ )
		{    children.add(countSibling, node);
				node = node.rightSibling;
			
		}
		children.add(countSibling,null);
		 int i =0 ;
		for(;i+1<countSibling;i+=2)
		{  children.set(i, this.merge(children.get(i), children.get(i+1)));
			
		}
		
		int j = i-2;
		if(j == countSibling - 3)
			children.set(j,merge(children.get(j),children.get(j+2)));
		
		
		for ( ; j >= 2; j -= 2)
            children.set(j-2,merge(children.get(j-2),children.get(j)));
        return children.get(0);
		
	}

	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}
	
	
	
}
