class Solution {
    public int maximumScore(int[] nums, int k) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            while (top >= 0 && nums[stack[top]] >= nums[i]) {
                top--;
            }
            left[i] = top < 0 ? 0 : stack[top] + 1;
            stack[++top] = i;
        }
        top = -1;
        for (int i = n - 1; i >= 0; i--) {
            while (top >= 0 && nums[stack[top]] >= nums[i]) {
                top--;
            }
            right[i] = top < 0 ? n - 1 : stack[top] - 1;
            stack[++top] = i;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] <= k && k <= right[i]) {
                ans = Math.max(ans, nums[i] * (right[i] - left[i] + 1));
            }
        }
        return ans;
    }
}