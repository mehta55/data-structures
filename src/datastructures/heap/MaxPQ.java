package datastructures.heap;

import java.util.ArrayList;
import java.util.List;

public class MaxPQ {

	private List<Integer> heap;

	public MaxPQ() {
		heap = new ArrayList<Integer>();
	}

	public void add(Integer x) {
		heap.add(x);
		int childIndex = size() - 1;
		int parentIndex = (childIndex - 1) / 2;
		while (parentIndex >= 0 && heap.get(parentIndex) < heap.get(childIndex)) {
			int temp = heap.get(childIndex);
			heap.set(childIndex, heap.get(parentIndex));
			heap.set(parentIndex, temp);
			childIndex = parentIndex;
			parentIndex = (childIndex - 1) / 2;
		}
	}
	
	public Integer peek() {
		if (isEmpty()) {
			return Integer.MIN_VALUE;
		}
		return heap.get(0);
	}

	public Integer poll() {
		
		if (isEmpty()) {
			return Integer.MIN_VALUE;
		} else if (size() == 1) {
			return heap.remove(0);
		}

		Integer x = heap.get(0);
		
		heap.set(0, heap.remove(size() - 1));

		int parentIndex = 0;
		while (parentIndex < size()) {
			int childIndexRight = parentIndex * 2 + 2;
			int childIndexLeft = parentIndex * 2 + 1;
			int childIndex = -1;

			if (childIndexLeft < size() && childIndexRight < size()) {
				childIndex = heap.get(childIndexLeft) > heap.get(childIndexRight) ? childIndexLeft : childIndexRight;				
			} else if (childIndexLeft < size()) {
				childIndex = childIndexLeft;
			}  else if (childIndexRight < size()) {
				childIndex = childIndexRight;				
			}
			
			if (childIndex != -1 && heap.get(parentIndex) < heap.get(childIndex)) {
				int temp = heap.get(parentIndex);
				heap.set(parentIndex, heap.get(childIndex));
				heap.set(childIndex, temp);
				parentIndex = childIndex;
			}
			
			if (parentIndex != childIndexLeft && parentIndex != childIndexRight) {
				break;
			}
		}
		
		return x;
	}

		public int size() {
			return heap.size();
		}

	public boolean isEmpty() {
		return size() == 0;
	}

}
