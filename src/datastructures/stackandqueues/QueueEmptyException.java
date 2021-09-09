package datastructures.stackandqueues;

public class QueueEmptyException extends Exception {

	private String message = "queue is empty!";

	public String getMessage() {
		return message;
	}

}
