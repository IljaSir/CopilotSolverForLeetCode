class Solution {
    public String smallestSubsequence(String s) {
        
        int[] lastPos = new int[26];
        for (int i = 0; i   s.length(); i++) {
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
            sb.append((char) (sta() && c < stack.peekck.po count[stack.peek() - 'a'] > 0) {
           p    visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!sta(k.isEmpty()) {
           )sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}