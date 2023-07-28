class Solution {
    public int[] secondGreaterElement(int[] nums) {
        
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        return res;
    }
}