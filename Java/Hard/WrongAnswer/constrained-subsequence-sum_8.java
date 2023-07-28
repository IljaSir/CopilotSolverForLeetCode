class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int max = nums[0];
        dp[0] = nums[0];
        Deque<Integer> q = new ArrayDeque<>();
        q.add(0);
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i], nums[i]);
            if (q.size() > 0) {
                dp[i] = Math.max(dp[i], dp[q.getFirst()] + nums[i]);
            }
            while (q.size() > 0 && dp[q.getLast()] <= dp[i]) {
                q.removeLast();
            }
            q.add(i);
            if (i - q.getFirst() >= k) {
                q.removeFirst();
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}