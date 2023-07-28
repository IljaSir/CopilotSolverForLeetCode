class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        
        int n = s.length();
        int[] count = new int[26];
        boolean[] seen = new boolean[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0 && stack.size() - 1 + n - i >= k) {
                char top = stack.pop();
                seen[top - 'a'] = false;
            }
            if (!seen[c - 'a'] && stack.size() < k) {
                stack.push(c);
                seen[c - 'a'] = true;
            }
            count[c - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        int l = sb.length();
        int num = 0;
        for (int i = 0; i < l; i++) {
            if (sb.charAt(i) == letter) {
                num++;
            }
        }
        if (num < repetition) {
            int diff = repetition - num;
            for (int i = 0; i < l; i++) {
                if (sb.charAt(i) != letter) {
                    sb.setCharAt(i, letter);
                    diff--;
                    if (diff == 0) {
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}