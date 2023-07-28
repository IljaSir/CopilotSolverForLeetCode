class Solution {
    public String removeDuplicateLetters(String s) {
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            if (visited[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty().pop() + 'a'));
        }
        return sb.reverse().toString();
    }
}