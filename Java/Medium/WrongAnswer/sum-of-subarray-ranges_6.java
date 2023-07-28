class Solution {
    public long subArrayRanges(int[] nums) {
        
        int n = nums.length;
        long[] left = new long[n];
        long[] right = new long[n];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = i + 1;
            } else {
                left[i] = i - stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[i] = n - i;
            } else {
                right[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += nums[i] * left[i] * right[i];
        }
        return ans;
    }
}