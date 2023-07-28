class Solution {
    public int shortestSubarray(int[] nums, int k) {
        
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int ans = n + 1;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < sums.length; i++) {
            while (!deque.isEmpty() && sums[i] <= sums[deque.getLast()]) {
                deque.removeLast();
            }
            while (!deque.isEmpty() && sums[i] - sums[deque.getFirst()] >= k) {
                ans = Math.min(ans, i - deque.removeFirst());
            }
            deque.addLast(i);
        }
        return ans < n + 1 ? ans : -1;
    }
}