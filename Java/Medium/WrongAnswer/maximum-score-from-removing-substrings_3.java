class Solution {
    public int maximumGain(String s, int x, int y) {
        
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        if (x < y) {
            int tmp = x;
            x = y;
            y = tmp;
            s = new StringBuilder(s).reverse().toString();
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                if (!stack.isEmpty() && stack.peek() == 'a') {
                    stack.pop();
                    ans += x;
                } else {
                    stack.push('b');
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        s = "";
        while (!stack.isEmpty()) {
            s += stack.pop();
        }
        stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                if (!stack.isEmpty() && stack.peek() == 'b') {
                    stack.pop();
                    ans += y;
                } else {
                    stack.push('a');
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return ans;
    }
}