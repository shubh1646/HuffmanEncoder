package Heaps;

import java.util.ArrayList;

public class FourWayHeap<T extends Comparable<T>> {
	ArrayList<T> list = new ArrayList<T>();

	public T top() {
		return list.get(3);
	}

	public FourWayHeap() {
		list.add(null);
		list.add(null);
		list.add(null);
	}

	public void push(T data) {
		list.add(data);
		int index = list.size() - 1;
		heapify(index);

	}

	public void heapify(int childIndex) {
		// int parent = (childIndex+4-2)/4; //this is for normal 4-way heap
		int parent = (childIndex - 4) / 4 + 3;
		if (parent >= 3 && list.get(childIndex).compareTo(list.get(parent)) > 0) {
			swap(parent, childIndex);
			heapify(parent);

		}
	}

	public T pop() {

		int n = list.size() - 1;
		swap(3, n);
		T element = list.remove(n);
		Downpify(3);
		return element;
	}

	void Downpify(int parent) {
		int c1 = (parent - 3) * 4 + 1 + 3;
		int c2 = (parent - 3) * 4 + 2 + 3;
		int c3 = (parent - 3) * 4 + 3 + 3;
		int c4 = (parent - 3) * 4 + 4 + 3;
		int maxPrio = parent;
		if (c1 <= list.size() - 1 && list.get(c1).compareTo(list.get(maxPrio)) > 0) {
			maxPrio = c1;
		}
		if (c2 <= list.size() - 1 && list.get(c2).compareTo(list.get(maxPrio)) > 0) {
			maxPrio = c2;
		}
		if (c3 <= list.size() - 1 && list.get(c3).compareTo(list.get(maxPrio)) > 0) {
			maxPrio = c3;
		}
		if (c4 <= list.size() - 1 && list.get(c4).compareTo(list.get(maxPrio)) > 0) {
			maxPrio = c4;
		}

		if (maxPrio != parent) {
			swap(maxPrio, parent);
			Downpify(maxPrio);
		}

	}

	void swap(int i, int j) {
		T element = list.get(i);
		list.set(i, list.get(j));
		list.set(j, element);
	}

	public int size() {
		return list.size() - 1;
	}
}
