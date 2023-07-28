class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        
        int[] res = new int[k];
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()] && n - i + stack.size() > k) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(i);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = nums[stack.pop()];
        }
        return res;
    }
}