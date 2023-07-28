class Solution {
    public int maxResult(int[] nums, int k) {
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(0);
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + dp[deque.getFirst()];
            while (!deque.isEmpty() && dp[deque.getLast()] < dp[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (deque.getFirst() == i - k) {
                deque.removeFirst();
            }
        }
        return dp[nums.length - 1];
    }
}