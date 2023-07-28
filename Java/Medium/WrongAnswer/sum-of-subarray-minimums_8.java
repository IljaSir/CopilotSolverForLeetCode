class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        int n = arr.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            next[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int ans = 0, mod = (int)1e9 + 7;
        for (int i = 0; i < n; i++) {
            ans = (ans + arr[i] * (i - prev[i]) * (next[i] - i)) % mod;
        }
        return ans;
    }
}