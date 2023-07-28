class Solution {
    public String removeDuplicateLetters(String s) {
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        boolean[] visited = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            count[idx]--;
            if (visited[idx]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[idx] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}