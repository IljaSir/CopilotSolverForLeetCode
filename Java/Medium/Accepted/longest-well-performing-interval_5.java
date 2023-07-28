class Solution {
    public int longestWPI(int[] hours) {
        
        int n = hours.length;
        int[] a = new int[n+1];
        for (int i = 0; i < n; i++) {
            a[i+1] = a[i] + (hours[i] > 8 ? 1 : -1);
        }
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            if (stack.isEmpty() || a[stack.peek()] > a[i]) {
                stack.push(i);
            }
        }
        for (int i = n; i >= res; i--) {
            while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
                res = Math.max(res, i - stack.pop());
            }
        }
        return res;
    }
}