class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        
        int n = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        int need = k - repetition;
        int have = 0;
        int[] seen = new int[26];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            while (!stack.isEmpty() && stack.peek() > c && cnt[stack.peek() - 'a'] - seen[stack.peek() - 'a'] > 0 && need > 0) {
                seen[stack.pop() - 'a']--;
                need--;
            }
            if (c == letter) {
                stack.push(c);
                seen[c - 'a']++;
                have++;
            } else if (have < repetition) {
                stack.push(c);
                seen[c - 'a']++;
                have++;
                need--;
            } else if (need > 0) {
                stack.push(c);
                seen[c - 'a']++;
                need--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}