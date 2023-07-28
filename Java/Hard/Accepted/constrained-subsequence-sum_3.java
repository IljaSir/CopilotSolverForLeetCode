class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int res = Integer.MIN_VALUE;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            if (!q.isEmpty()) {
                dp[i] = Math.max(dp[i], dp[q.peekFirst()] + nums[i]);
            }
            res = Math.max(res, dp[i]);
            while (!q.isEmpty() && dp[q.peekLast()] <= dp[i]) {
                q.pollLast();
            }
            q.offerLast(i);
            if (q.peekFirst() == i - k) {
                q.pollFirst();
            }
        }
        return res;
    }
}