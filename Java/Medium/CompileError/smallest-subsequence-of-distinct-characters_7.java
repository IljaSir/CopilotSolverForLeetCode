class Solution {
    public String smallestSubsequence(String s) {
        
        Stack<Character> stack = newStack<();
       int[] lastIndex = new int[26];
        boolean[] visited = new boolean[26];
        for (int i = ; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (visited[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i
        }
        return sb.reverse().toString();
    }
}