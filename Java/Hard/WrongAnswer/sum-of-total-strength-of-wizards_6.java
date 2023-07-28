class Solution {
    public int totalStrength(int[] strength) {
        
        int n = strength.length;
        long mod = 1000000007;
        long[] left = new long[n];
        long[] right = new long[n];
        long[] sum = new long[n];
        Stack<Integer> stack = new Stack<>();
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
        for (int i = 0; i < n; i++) {
            sum[i] = strength[i] * (i - left[i]) * (right[i] - i);
        }
        long ans = 0;
        for (long v : sum) {
            ans += v;
            ans %= mod;
        }
        return (int) ans;
    }
}