package datastructures.stackandqueues;

public class StackProblems {

	public static void main(String[] args) {
		
//		implementation();
		
//		System.out.println(isBalanced("(()())("));
		
//		java.util.Stack<Integer> stack1 = new java.util.Stack<>();
//		java.util.Stack<Integer> stack2 = new java.util.Stack<>();
//		stack1.push(5);
//		stack1.push(4);
//		stack1.push(3);
//		stack1.push(2);
//		stack1.push(1);
//		System.out.println(stack1);
//		reverseStack(stack1, stack2);
//		System.out.println(stack1);
		
		
//		System.out.println(checkRedundantBrackets("(x+y*(a-b))"));

		int[] span = stockSpan(new int[] {100, 80, 60, 70,60, 75, 85});
		for(int i = 0; i < span.length; i++) {
			System.out.print(span[i] + " ");
		}
		
	}

	private static int[] stockSpan(int[] prices) {
		java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
		int[] span = new int[prices.length];
		stack.push(0);
        span[0] = 1;
		for(int i = 1; i < prices.length; i++) {
			while(!stack.isEmpty() && prices[stack.peek()] < prices[i]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				span[i] = i + 1;
			} else {
				span[i] = i - stack.peek();
			}
			stack.push(i);
		}
		return span;
	}

	private static boolean checkRedundantBrackets(String exp) {
		java.util.Stack<Character> stack = new java.util.Stack<Character>();
		for(int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if(ch != ')') {				
				stack.push(ch);
			} else {
				int poppedCount = 0;
				while(!stack.isEmpty() && stack.peek() != '(') {
					char poppedCh = stack.pop();
					if(!((poppedCh >= 65 && poppedCh <= 90) || (poppedCh >= 97 && poppedCh <= 123))) {
						poppedCount++;
					}
				}
				if(poppedCount == 0) {
					return true;
				} 
				stack.pop();
			}
		}
		return false;
	}

	private static void reverseStack(java.util.Stack<Integer> stack1, java.util.Stack<Integer> stack2) {
		if(stack1.size() == 1) {
			return;
		}
		
		int val = stack1.pop();
		reverseStack(stack1, stack2);
		
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		stack1.push(val);
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
	}

	private static boolean isBalanced(String exp) {
		java.util.Stack<Character> stack = new java.util.Stack<>();
		for(int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if(ch == ')') {
				if(stack.isEmpty()) {
					return false;
				} else if(stack.peek() == '(') {
					stack.pop();
				} else {
					stack.push(ch);
				}
			} else {
				stack.push(ch);				
			}
		}
		
		return stack.isEmpty();
	}

	private static void implementation() {
		Stack<String> s = new Stack<>();
		try {
			System.out.println(s.isEmpty());
			System.out.println(s.pop());
		} catch (StackEmptyException e) {
			System.out.println(e.getMessage());
		}

		try {
			s.push("first");
			s.push("second");
			System.out.println(s.top());
			s.push("third");
			System.out.println(s.size());
			System.out.println(s.pop());
			System.out.println(s.pop());
			System.out.println(s.isEmpty());
			System.out.println(s.size());
			System.out.println(s.top());
			System.out.println(s.pop());
			System.out.println(s.size());
			System.out.println(s.top());
			
		} catch (StackEmptyException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
