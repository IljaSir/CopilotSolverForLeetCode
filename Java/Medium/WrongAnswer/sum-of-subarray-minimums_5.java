class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        int MOD = 1_000_000_007;
        int N = arr.length;
        int[] left = new int[N];
        int[] right = new int[N];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < N; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                stack.pop();
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack = new Stack();
        for (int i = N-1; i >= 0; --i) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            right[i] = stack.isEmpty() ? N : stack.peek();
            stack.push(i);
        }

        long ans = 0;
        for (int i = 0; i < N; ++i) {
            ans += arr[i] * (i - left[i]) * (right[i] - i);
            ans %= MOD;
        }

        return (int) ans;
    }
}