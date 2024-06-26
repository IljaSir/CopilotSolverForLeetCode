class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        int MOD = 1000000007;
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                stack.pop();
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack = new Stack();
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        long ans = 0;
        for (int i = 0; i < n; ++i)
            ans += arr[i] * (i - left[i]) * (right[i] - i);
        return (int) (ans % MOD);
    }
}