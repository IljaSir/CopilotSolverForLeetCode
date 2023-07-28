class Solution {
    public String removeDuplicates(String s, int k) {
        
        int[] count = new int[s.length()];
        char[] stack = s.toCharArray();
        int top = 0;
        for (int i = 0; i < s.length(); ++i, ++top) {
            stack[top] = s.charAt(i);
            count[top] = 1;
            if (top > 0 && stack[top - 1] == stack[top]) {
                count[top] = count[top - 1] + 1;
            }
            if (count[top] == k) {
                top -= k;
            }
        }
        return new String(stack, 0, top);
    }
}