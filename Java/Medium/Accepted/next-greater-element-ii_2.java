class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length * 2; i++) {
            int n = nums[i % nums.length];
            while (!stack.isEmpty() && nums[stack.peek()] < n) {
                res[stack.pop()] = n;
            }
            if (i < nums.length) {
                stack.push(i);
            }
        }
        return res;
    }
}