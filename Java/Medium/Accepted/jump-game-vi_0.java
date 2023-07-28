class Solution {
    public int maxResult(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.offer(new int[]{dp[0], 0});
        for (int i = 1; i < n; i++) {
            while (pq.peek()[1] < i - k) {
                pq.poll();
            }
            dp[i] = pq.peek()[0] + nums[i];
            pq.offer(new int[]{dp[i], i});
        }
        return dp[n - 1];
    }
}