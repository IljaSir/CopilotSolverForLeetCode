class Solution {
    public String minRemoveToMakeValid(String s) {
        
        int n = s.length();
        int[] stack = new int[n];
        int top = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack[top++] = i;
            } else if (c == ')') {
                if (top > 0) {
                    top--;
                } else {
                    stack[top++] = i;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < n; i++) {
            if (j < top && stack[j] == i) {
                j++;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}