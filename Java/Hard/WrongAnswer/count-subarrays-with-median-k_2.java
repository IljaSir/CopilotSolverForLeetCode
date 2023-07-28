class Solution {
    public int countSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        int[] pos = new int[n+1];
        for (int i = 0; i < n; i++) {
            pos[nums[i]] = i;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && pos[stack.peek()] < pos[nums[i]]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = i + 1;
            } else {
                left[i] = i - pos[stack.peek()];
            }
            stack.push(nums[i]);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && pos[stack.peek()] < pos[nums[i]]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[i] = n - i;
            } else {
                right[i] = pos[stack.peek()] - i;
            }
            stack.push(nums[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                ans += left[i] * right[i];
            }
        }
        return ans;
    }
}