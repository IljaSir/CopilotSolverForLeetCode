class Solution {
    public boolean canBeValid(String s, String locked) {
        
        int n = s.length();
        int[] stack = new int[n];
        int top = -1;
        char[] sChars = s.toCharArray();
        char[] lChars = locked.toCharArray();
        for (int i = 0; i < n; i++) {
            if (lChars[i] == '1') {
                continue;
            }
            if (sChars[i] == '(') {
                stack[++top] = i;
            } else {
                if (top == -1) {
                    sChars[i] = '(';
                } else {
                    top--;
                }
            }
        }
        top = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (lChars[i] == '1') {
                continue;
            }
            if (sChars[i] == ')') {
                stack[++top] = i;
            } else {
                if (top == -1) {
                    sChars[i] = ')';
                } else {
                    top--;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (lChars[i] == '0') {
                continue;
            }
            if (sChars[i] == '(') {
                if (top == -1) {
                    return false;
                }
                if (stack[top--] != i) {
                    return false;
                }
            }
        }
        return true;
    }
}