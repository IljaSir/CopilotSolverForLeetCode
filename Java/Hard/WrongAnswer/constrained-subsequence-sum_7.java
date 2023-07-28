class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(0);
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] + (deque.isEmpty() ? 0 : dp[deque.peekFirst()]);
            max = Math.max(max, dp[i]);
            while (!deque.isEmpty() && dp[i] > dp[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
        }
        return max;
    }
}