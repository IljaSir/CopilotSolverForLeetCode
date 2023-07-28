class Solution {
    public int totalStrength(int[] strength) {
        
        int mod = 1000000007;
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
            long sum = (long) strength[i] * (right[i] - left[i] - 1);
            ans = (ans + sum * strength[i]) % mod;
        }
        return (int) ans;
    }
}