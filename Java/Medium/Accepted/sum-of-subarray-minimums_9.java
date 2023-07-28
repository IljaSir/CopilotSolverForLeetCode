class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        int n = arr.length;
        int MOD = 1000000007;
        int[] prev = new int[n];
        int[] next = new int[n];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                stack.pop();
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack = new Stack();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            next[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += arr[i] * (long)(i - prev[i]) * (long)(next[i] - i);
            ans %= MOD;
        }
        return (int) ans;
    }
}