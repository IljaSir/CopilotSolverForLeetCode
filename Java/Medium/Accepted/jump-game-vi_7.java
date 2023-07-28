class Solution {
    public int maxResult(int[] nums, int k) {
        
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(0);
        for (int i = 1; i < n; i++) {
            while (!deque.isEmpty() && i - deque.peekFirst() > k) {
                deque.pollFirst();
            }
            dp[i] = dp[deque.peekFirst()] + nums[i];
            while (!deque.isEmpty() && dp[i] >= dp[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return dp[n - 1];
    }
}