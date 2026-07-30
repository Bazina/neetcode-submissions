class MinStack {
    Stack<Integer> minStack;
    Stack<Integer> stack;


    public MinStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int val) {
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.add(val);
        }
        stack.add(val);
    }

    public void pop() {
        if (stack.peek().compareTo(minStack.peek()) == 0) {
            minStack.pop();
        }

        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
