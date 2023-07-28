class Solution {
    public String removeDuplicates(String s, int k) {
        
        Stack<Integer> count = new Stack<>();
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == c) {
                count.push(count.pop() + 1);
            } else {
                count.push(1);
            }
            stack.push(c);
            if(count.peek() == k) {
                for(int i = 0; i < k; i++) {
                    stack.pop();
                    count.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}