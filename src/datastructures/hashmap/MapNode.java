package datastructures.hashmap;

public class MapNode<K, V> {

	private K key;
	private V value;
	private MapNode<K, V> next;

	public MapNode(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public MapNode<K, V> getNext() {
		return next;
	}

	public void setNext(MapNode<K, V> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[key=");
		builder.append(key);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		builder.append("=>");
		builder.append(next);		
		return builder.toString();
	}

	
}
