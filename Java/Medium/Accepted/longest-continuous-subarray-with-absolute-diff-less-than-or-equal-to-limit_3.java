class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        int n = nums.length;
        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();
        int ans = 0;
        for (int i = 0, j = 0; i < n; i++) {
            while (!max.isEmpty() && nums[max.peekLast()] <= nums[i]) {
                max.pollLast();
            }
            max.offerLast(i);
            while (!min.isEmpty() && nums[min.peekLast()] >= nums[i]) {
                min.pollLast();
            }
            min.offerLast(i);
            while (nums[max.peekFirst()] - nums[min.peekFirst()] > limit) {
                if (max.peekFirst() < min.peekFirst()) {
                    j = max.pollFirst() + 1;
                } else {
                    j = min.pollFirst() + 1;
                }
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}