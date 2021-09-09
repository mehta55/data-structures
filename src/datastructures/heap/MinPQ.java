package datastructures.heap;

import java.util.ArrayList;
import java.util.List;

public class MinPQ {

	private List<Integer> heap;

	public MinPQ() {
		heap = new ArrayList<>();
	}

	public void add(Integer x) {
		heap.add(x);
		upHeapify();
	}

	private void upHeapify() {
		int childIndex = size() - 1;
		int parentIndex = (childIndex - 1) / 2;
		while (parentIndex >= 0 && heap.get(childIndex) < heap.get(parentIndex)) {
			int temp = heap.get(childIndex);
			heap.set(childIndex, heap.get(parentIndex));
			heap.set(parentIndex, temp);
			childIndex = parentIndex;
			parentIndex = (childIndex - 1) / 2;
		}
	}

	public Integer peek() {
		return heap.get(0);
	}

	public Integer poll() throws PriorityQueueException {

		if (isEmpty()) {
			throw new PriorityQueueException();
		}
		if (size() == 0) {
			return heap.remove(0);
		}

		int x = heap.get(0);
		heap.set(0, heap.get(size() - 1));
		heap.remove(size() - 1);
		downHeapify();
		return x;
	}

	private void downHeapify() {
		int parentIndex = 0;
		while (parentIndex < size()) {
			int childIndexLeft = parentIndex * 2 + 1;
			int childIndexRight = parentIndex * 2 + 2;
			int childIndex = -1;

			if (childIndexLeft < size() && childIndexRight < size()) {
				childIndex = heap.get(childIndexLeft) < heap.get(childIndexRight) ? childIndexLeft : childIndexRight;
			} else if (childIndexLeft < size()) {
				childIndex = childIndexLeft;
			} else if (childIndexRight < size()) {
				childIndex = childIndexRight;
			}

			if (childIndex != -1 && heap.get(childIndex) < heap.get(parentIndex)) {
				int temp = heap.get(parentIndex);
				heap.set(parentIndex, heap.get(childIndex));
				heap.set(childIndex, temp);
				parentIndex = childIndex;
			} else {
				return;
			}
		}
	}

	public int size() {
		return heap.size();
	}

	public boolean isEmpty() {
		return size() == 0;
	}
}

class PriorityQueueException extends Exception {

}
