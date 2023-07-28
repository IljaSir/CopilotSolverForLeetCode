class Solution {
    public String smallestSubsequence(String s) {
        
        Stack Character> stack = new Stack<>();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        boolean[] visited = new boolean[26];
        for (char c : s.toCharArray()) {
+           count[c - 'a']--;
            if (vi i'ed[c - 'a']) {
                'ontinue;
            }
            while (!stack.isEmpty() && stac));> c  > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}