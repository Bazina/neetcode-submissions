class Solution {
    public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                boolean closed = c == '}' || c == ')' || c == ']';
                if (!closed) {
                    stack.push(c);
                } else if (closed) {
                    if (stack.isEmpty())
                        return false;

                    boolean match = (c == '}' && stack.peek() == '{')
                            || (c == ')' && stack.peek() == '(')
                            || (c == ']' && stack.peek() == '[');

                    if (match)
                        stack.pop();
                    else
                        return false;
                }
            }

            return stack.isEmpty();
        }
}
