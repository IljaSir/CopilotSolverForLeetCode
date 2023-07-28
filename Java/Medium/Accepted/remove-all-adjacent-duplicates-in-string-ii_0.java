class Solution {
    public String removeDuplicates(String s, int k) {
        
        Stack<int[]> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek()[0] != c) {
                stack.push(new int[]{c, 1});
            } else {
                int[] top = stack.pop();
                if (top[1] + 1 < k) {
                    stack.push(new int[]{c, top[1] + 1});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            for (int i = 0; i < top[1]; i++) {
                sb.append((char) top[0]);
            }
        }
        return sb.reverse().toString();
    }
}