class Solution {
    public int totalStrength(int[] strength) {
        
        int n = strength.length;
        int mod = (int) 1e9 + 7;
        int[] next = new int[n];
        int[] prev = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && strength[stack.peek()] >= strength[i]) {
                stack.pop();
            }
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && strength[stack.peek()] >= strength[i]) {
                stack.pop();
            }
            next[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int left = i - prev[i];
            int right = next[i] - i;
            ans += (long) strength[i] * left * right;
        }
        return (int) (ans % mod);
    }
}