class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        
        int[] res = new int[k];
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] < stack.peekLast() && stack.size() - 1 + n - i >= k) {
                stack.pollLast();
            }
            if (stack.size() < k) {
                stack.offerLast(nums[i]);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = stack.pollLast();
        }
        return res;
    }
}