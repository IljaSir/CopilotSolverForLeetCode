class Solution {
    public int shortestSubarray(int[] nums, int k) {
        
        if (nums.length == 0) return -1;
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        Deque<Integer> deque = new LinkedList<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < sum.length; i++) {
            while (!deque.isEmpty() && sum[i] - sum[deque.peekFirst()] >= k) {
                res = Math.min(res, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && sum[i] <= sum[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}