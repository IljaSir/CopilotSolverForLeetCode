class Solution {
    public int[] smallestSubarrays(int[] nums) {
        
        int n = nums.length;
        int[] ret = new int[n];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            while (!dq.isEmpty() && dq.peekFirst() <= i - 31) {
                dq.pollFirst();
            }
            ret[i] = i - dq.peekFirst() + 1;
        }
        return ret;
    }
}