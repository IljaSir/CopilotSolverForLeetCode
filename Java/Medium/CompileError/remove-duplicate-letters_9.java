class Solution {
    public String removeDuplicateLetters(String s) {
        
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            count[ch]--;
            if (visited[ch]) continue;
            while (!st.isEmpty() && st.peek() > ch && count[st.peek()] > 0) {
                visited[st.pop()] = false;
            }
            st.push(ch);
            visited[ch] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append((char) (st && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}