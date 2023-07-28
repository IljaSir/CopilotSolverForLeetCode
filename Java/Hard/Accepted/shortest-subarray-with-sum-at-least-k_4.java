class Solution {
    public int shortestSubarray(int[] nums, int k) {
        
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int res = n + 1;
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && preSum[i] - preSum[deque.getFirst()] >= k) {
                res = Math.min(res, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && preSum[i] <= preSum[deque.getLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return res == n + 1 ? -1 : res;
    }
}