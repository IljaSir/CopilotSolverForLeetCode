class Solution {
    public long countSubarrays(int[] nums, long k) {
        
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        long ans = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i <= n; ++i) {
            while (!deque.isEmpty() && prefix[i] <= prefix[deque.peekLast()]) {
                deque.pollLast();
            }
            while (!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= k) {
                deque.pollFirst();
            }
            ans += deque.size();
            deque.offerLast(i);
        }
        return ans;
    }
}