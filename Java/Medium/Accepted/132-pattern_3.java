class Solution {
    public boolean find132pattern(int[] nums) {
        
        int len = nums.length;
        int[] min = new int[len];
        min[0] = nums[0];
        for (int i = 1; i < len; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int j = len - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }
                stack.push(nums[j]);
            }
        }
        return false;
    }
}