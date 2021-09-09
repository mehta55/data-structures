package datastructures.hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class MyHashMap<K, V> {

	private List<MapNode<K, V>> bucket;
	private int bucketSize;
	private int size;
	private double loadFactor;
	private static final double LOAD_FACTOR = 0.75;
	private static final int DEFAULT_BUCKET_SIZE = 5;
	private static final double GROWING_RATE = 1.5;
	
		
	public MyHashMap() {
		bucketSize = DEFAULT_BUCKET_SIZE;
		this.bucket = new ArrayList<>();
		this.size = 0;
		this.loadFactor = LOAD_FACTOR;
		for (int i = 0; i < bucketSize; i++) {
			this.bucket.add(null);
		}
	}

	public MyHashMap(int size, double loadFactor) {
		this.bucketSize = size;
		this.bucket = new ArrayList<>();
		this.size = 0;
		this.loadFactor = loadFactor;
		for (int i = 0; i < bucketSize; i++) {
			this.bucket.add(null);
		}
	}
	
	private int getIndex(K key) {
		int hash = key.hashCode();
		return hash % bucketSize;
	} 
	
	public void put(K key, V value) {
		double currLoad = size / bucketSize;
		if (currLoad > loadFactor) {
			rehash();
		}
		
		int index = getIndex(key);
		MapNode<K, V> newEntry = new MapNode<>(key, value);
		MapNode<K, V> headEntry = get(index);
		
		if(headEntry == null) {
			bucket.set(index, newEntry);
		} else {
			while (headEntry.getNext() != null && !headEntry.getKey().equals(key)) {
				headEntry = headEntry.getNext();
			} 
			if (headEntry.getKey().equals(key)) {
				headEntry.setValue(value);
				size--;
			} else {
				headEntry.setNext(newEntry);
			}
			
		}
		size++;
	} 
	
	private MapNode<K, V> get(int index) {
		if (index < bucket.size()) {
			return bucket.get(index);
		}
		return null;
	}
	
	public V get(K key) {
		int index = getIndex(key);
		MapNode<K, V> entry = get(index);
		V value = null;
		if (entry != null && entry.getKey().equals(key)) {
			value = entry.getValue();
		} else {
			while (entry != null && !entry.getKey().equals(key)) {
				entry = entry.getNext();
			}
			if(entry != null) {
				value = entry.getValue();
			}
		}

		return value;
	}

	private void rehash() {
		List<MapNode<K, V>> oldBuckey = bucket;
		bucketSize = (int) (bucketSize * GROWING_RATE);
		size = 0;
		bucket = new ArrayList<>(bucketSize);
		for (int i =0; i < bucketSize; i++) {
			bucket.add(null);
		}
		
		oldBuckey.stream().filter(Objects::nonNull)
		.forEach(entry -> {
			do {
				put(entry.getKey(), entry.getValue());
				entry = entry.getNext();
			} while (entry != null);
		});
	}
	
	public boolean remove(K key) {
		boolean removed = false;
		int index = getIndex(key);
		MapNode<K, V> entry = get(index);
		if (entry != null) {
			if (entry.getKey().equals(key)) {
				bucket.set(index, entry.getNext());
				removed = true;
			} else {
				MapNode<K, V> prevEntry = null;
				while (entry != null && !entry.getKey().equals(key)) {
					prevEntry = entry;
					entry = entry.getNext();
				}
				if(entry != null) {
					prevEntry.setNext(entry.getNext());
					removed = true;
				}
			}
		}
		size--;
		return removed;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[bucket=");
		builder.append(bucket);
		builder.append("]");
		return builder.toString();
	}
	
}
