class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }
        int[] used = new int[26];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count[c - 'a']--;
            if (used[c - 'a'] > 0) {
                used[c - 'a']--;
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                used[stack.pop() - 'a']--;
            }
            if (stack.size() < k) {
                stack.push(c);
                used[c - 'a']++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        int l = sb.length();
        int c = 0;
        for (int i = 0; i < l; i++) {
            if (sb.charAt(i) == letter) {
                c++;
            }
        }
        if (c < repetition) {
            for (int i = 0; i < repetition - c; i++) {
                sb.append(letter);
            }
        }
        return sb.toString();
    }
}