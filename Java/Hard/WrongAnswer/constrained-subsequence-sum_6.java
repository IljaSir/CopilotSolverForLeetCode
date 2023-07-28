class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i] + (dq.isEmpty() ? 0 : dq.peekFirst());
            max = Math.max(max, dp[i]);
            while (!dq.isEmpty() && dq.peekLast() < dp[i]) {
                dq.pollLast();
            }
            dq.offerLast(dp[i]);
            if (i >= k && dq.peekFirst() == dp[i - k]) {
                dq.pollFirst();
            }
        }
        return max;
    }
}