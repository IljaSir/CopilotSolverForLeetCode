class Solution {
    public String removeDuplicates(String s, int k) {
        
        Stack<Integer> count = new Stack<>();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                count.push(count.pop() + 1);
            } else {
                count.push(1);
            }
            stack.push(c);
            if (count.peek() == k) {
                count.pop();
                for (int i = 0; i < k; i++) {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}