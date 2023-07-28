class Solution {
    public String smallestSubsequence(String s) {
        
        int[] fretPos = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastPos[s.charAt(i) - 'a'] = i;
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (visited[c]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && lastPos[stack.peek()] > i) {
                visited[stack.pop()] = false;
            }
            stack.push(c);
            visited[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append((char) (stack.pop() + 'a'));
        }(stack.pop());
        }
        return sb.reverse().toString();
    }
}