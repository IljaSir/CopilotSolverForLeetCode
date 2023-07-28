class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            if (!q.isEmpty()) {
                dp[i] = Math.max(dp[i], nums[i] + q.peek());
            }
            max = Math.max(max, dp[i]);
            while (!q.isEmpty() && q.peekLast() < dp[i]) {
                q.pollLast();
            }
            q.offer(dp[i]);
            if (i >= k && q.peek() == dp[i - k]) {
                q.poll();
            }
        }
        return max;
    }
}