class Solution {
    public int maxResult(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        for (int i = 1; i < n; ++i) {
            dp[i] = nums[i] + dp[deque.peekFirst()];
            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
        }
        return dp[n - 1];
    }
}