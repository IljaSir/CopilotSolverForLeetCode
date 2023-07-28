class Solution {
    public int shortestSubarray(int[] nums, int k) {
        
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int res = n + 1;
        for (int i = 0; i < sum.length; i++) {
            while (!deque.isEmpty() && sum[i] <= sum[deque.getLast()]) {
                deque.removeLast();
            }
            while (!deque.isEmpty() && sum[i] >= sum[deque.getFirst()] + k) {
                res = Math.min(res, i - deque.removeFirst());
            }
            deque.addLast(i);
        }
        return res <= n ? res : -1;
    }
}