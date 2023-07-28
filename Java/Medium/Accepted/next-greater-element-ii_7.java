class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length * 2; i++) {
            int index = i % nums.length;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                result[stack.pop()] = nums[index];
            }
            if (i < nums.length) {
                stack.push(i);
            }
        }
        return result;
    }
}