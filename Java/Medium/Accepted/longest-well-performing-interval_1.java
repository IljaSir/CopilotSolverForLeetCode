class Solution {
    public int longestWPI(int[] hours) {
        
        int n = hours.length;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + (hours[i] > 8 ? 1 : -1);
        }
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            if (stack.isEmpty() || pre[stack.peek()] > pre[i]) {
                stack.push(i);
            }
        }
        for (int i = n; i >= 0; i--) {
            while (!stack.isEmpty() && pre[stack.peek()] < pre[i]) {
                res = Math.max(res, i - stack.pop());
            }
        }
        return res;
    }
}