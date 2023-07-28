class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        int n = nums.length;
        int i = 0;
        int j = 0;
        int max = 0;
        Deque<Integer> maxq = new LinkedList<>();
        Deque<Integer> minq = new LinkedList<>();
        while (j < n) {
            while (!maxq.isEmpty() && maxq.peekLast() < nums[j]) {
                maxq.pollLast();
            }
            while (!minq.isEmpty() && minq.peekLast() > nums[j]) {
                minq.pollLast();
            }
            maxq.addLast(nums[j]);
            minq.addLast(nums[j]);
            while (!maxq.isEmpty() && !minq.isEmpty() && maxq.peekFirst() - minq.peekFirst() > limit) {
                if (nums[i] == maxq.peekFirst()) {
                    maxq.pollFirst();
                }
                if (nums[i] == minq.peekFirst()) {
                    minq.pollFirst();
                }
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}