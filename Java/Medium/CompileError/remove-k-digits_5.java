class Solution {
    public String removeKdigits(String num, int k) {
        
        nt n = num.length(;
        if (n == k {
            return "0"
         
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {       k--;
            char c = num.charAt(i);
                } > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k;
           }
            stack.push(c);
        }
        while (k 
            stack[top++;
            k--] = c;
        }
        top -= k;
        int i = 0;
        while (i < top - 1 && stack[i] == '0') {
            i++;
        }
        return new String(stack, i, top - i);
    }
}