class Solution {
    public int totalStrength(int[] strength) {
        
        int mod = (int)1e9 + 7;
        int n = strength.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && strength[stack.peek()] >= strength[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && strength[stack.peek()] > strength[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long)strength[i] * (i - left[i]) * (right[i] - i)) % mod;
        }
        return (int)ans;
    }
}