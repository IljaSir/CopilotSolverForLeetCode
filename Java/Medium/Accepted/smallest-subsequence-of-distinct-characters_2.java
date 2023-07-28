class Solution {
    public String smallestSubsequence(String s) {
        
        int[] last = new int[26];
        for (int i = 0; i < s.length(); ++i)
            last[s.charAt(i) - 'a'] = i;

        Stack<Integer> stack = new Stack();
        for (int i = 0; i < s.length(); ++i) {
            int c = s.charAt(i) - 'a';
            if (!stack.contains(c)) {
                while (!stack.isEmpty() && stack.peek() > c && i < last[stack.peek()]) {
                    stack.pop();
                }
                stack.push(c);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i: stack) ans.append((char) ('a' + i));
        return ans.toString();
    }
}