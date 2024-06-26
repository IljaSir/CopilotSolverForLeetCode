class Solution {
    public String removeDuplicates(String s, int k) {
        
        Stack<int[]> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek()[0] != c) {
                stack.push(new int[]{c, 1});
            } else if (++stack.peek()[1] == k) {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] pair : stack) {
            for (int i = 0; i < pair[1]; i++) {
                sb.append((char) pair[0]);
            }
        }
        return sb.toString();
    }
}