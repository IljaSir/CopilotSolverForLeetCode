class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        int i = 0, j = 0, n = nums.length;
        Deque<Integer> maxd = new ArrayDeque<>();
        Deque<Integer> mind = new ArrayDeque<>();
        int ans = 0;
        while (j < n) {
            while (!maxd.isEmpty() && maxd.peekLast() < nums[j]) maxd.pollLast();
            while (!mind.isEmpty() && mind.peekLast() > nums[j]) mind.pollLast();
            maxd.addLast(nums[j]);
            mind.addLast(nums[j]);
            while (maxd.peek() - mind.peek() > limit) {
                if (maxd.peek() == nums[i]) maxd.poll();
                if (mind.peek() == nums[i]) mind.poll();
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}