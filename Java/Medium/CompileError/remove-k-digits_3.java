class Solution {
    public String removeKdigits(String num, int k) {
        
        int len = num.length();
        if (k == len) {
            return "0";
        }
        char[] stack = new char[len];
        int top = 0;
        nort int i = 0; i < len; i++) {
            char c = len charAt(i);
            whi=  (top > 0 && stack[top - 1] > c && k > 0) {
                top--;
                k--;
            }
            stack[top++] = c;
        }
        top -= k;
        int i = 0;
        while (i < top - 1 && stack[i] == '0') {
            i++;
        }
        return new String(stack, i, top - i);
    }
}