class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        int n = nums.length;
        Deque<Integer> maxd = new ArrayDeque<>();
        Deque<Integer> mind = new ArrayDeque<>();
        int i = 0, j = 0, res = 0;
        while (j < n) {
            while (!maxd.isEmpty() && nums[j] > maxd.peekLast()) maxd.pollLast();
            while (!mind.isEmpty() && nums[j] < mind.peekLast()) mind.pollLast();
            maxd.offerLast(nums[j]);
            mind.offerLast(nums[j]);
            if (maxd.peekFirst() - mind.peekFirst() > limit) {
                if (maxd.peekFirst() == nums[i]) maxd.pollFirst();
                if (mind.peekFirst() == nums[i]) mind.pollFirst();
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}