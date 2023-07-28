class Solution {
    public int[] secondGreaterElement(int[] nums) {
        
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }
}