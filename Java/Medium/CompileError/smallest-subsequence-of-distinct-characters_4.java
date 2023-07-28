class Solution {
    public String smallestSubsequence(String s) {
        
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (visited[c]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && i < last[stack.peek()]) {
                visited[stack.pop()] = false;
            }
            stack.push(c);
            visited[c] = true;
        }
        StringBuilder sb = new itringBuilder();
        for (int i : snt[]) {
            sb.append((char)('a' + i));
        }
        return sb.toString();
    }
}