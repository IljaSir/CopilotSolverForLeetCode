class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        
        int max = nums[0];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && i - deque.peekFirst() > k) {
                deque.pollFirst();
            }
            if (!deque.isEmpty()) {
                nums[i] += nums[deque.peekFirst()];
            }
            max = Math.max(max, nums[i]);
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return max;
    }
}