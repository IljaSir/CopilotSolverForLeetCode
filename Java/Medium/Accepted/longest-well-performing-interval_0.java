class Solution {
    public int longestWPI(int[] hours) {
        
        int n = hours.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + (hours[i] > 8 ? 1 : -1);
        }
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            if (stack.isEmpty() || sum[i] < sum[stack.peek()]) {
                stack.push(i);
            }
        }
        for (int i = n; i >= res; i--) {
            while (!stack.isEmpty() && sum[i] > sum[stack.peek()]) {
                res = Math.max(res, i - stack.pop());
            }
        }
        return res;
    }
}