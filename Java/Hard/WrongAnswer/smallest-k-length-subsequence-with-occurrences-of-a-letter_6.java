class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        
        int[] count = new int[26];
        int[] used = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (used[c - 'a'] == 0) {
                while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] >= repetition) {
                    used[stack.pop() - 'a'] = 0;
                }
            }
            if (used[c - 'a'] < repetition) {
                stack.push(c);
                used[c - 'a']++;
            }
            count[c - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}