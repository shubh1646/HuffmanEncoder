 package Heaps;

import java.util.ArrayList;

public class GenericHeap<T extends Comparable<T>> {
		
		public ArrayList<T> list = new ArrayList<T>(); 
		
		
		
		public GenericHeap()
		{  list.add(null); //blocking zero index
		}
		
		
		public int size()
		{
			return list.size()-1;
		}
		
		
		public int isLarger(T t , T o) 
		{
			return t.compareTo(o);
		}
		
		public void push(T data )
		{  list.add(data); //insert at last
			//take it to the correct position to maintain heap property 
			int index = list.size()-1;
			RupHeapify(index);
			//upHeapify(index);
			
			
		}
		
		private void RupHeapify(int index)
		{  int parent = index/2;
			if(index > 1 && isLarger(list.get(index),list.get(parent))>0)
			{
				swap(index,parent);
				RupHeapify(parent);
			}
			
			
		}
		private void upHeapify(int index)
		{  int parent = index/2;
			while(index>1 &&  isLarger(list.get(index),list.get(parent))>0)
			{
				swap(index,parent);
				index = parent; 
				parent = parent/2;
			}
			
			
		}
		
		
		private void swap(int i , int j)
		{	T ele = list.get(i);  
			list.set(i,list.get(j));
			list.set(j, ele);
		}
		
		
		
	  public T pop()
	  {  int index = list.size()-1;
	    swap(1,index);
	    T element  = list.remove(index);;
	   
	    downHeapify(1);
	    return element;
	  }

	  
	  
	  private void downHeapify(int parentIndex )
	  {
		  int child1 = 2*parentIndex;
		  int child2 = 2*parentIndex+1;
		  //assume current is min 
		  int maxPrio = parentIndex;
		  
		  if(child1<list.size() && isLarger(list.get(child1),list.get(parentIndex))>0)
		  {
			  maxPrio = child1;
		  }
		  
		  if(child2<list.size() && isLarger(list.get(child2),list.get(parentIndex))>0)
		  {
			  maxPrio = child2;
		  }  
		  
		  
		  if(maxPrio!=parentIndex)
		  {
			  
			  swap(parentIndex,maxPrio);
			  downHeapify(maxPrio);
		  }
	  }
		
		
		
		
		
		public T top()
		
		{
			return list.get(1);
		}
		

	
	}



