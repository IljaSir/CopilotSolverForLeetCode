class Solution {
    public int countSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        int[] left = new int[n], right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = 1;
            if (nums[i] < nums[i - 1]) {
                left[i] += left[i - 1];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = 1;
            if (nums[i] < nums[i + 1]) {
                right[i] += right[i + 1];
            }
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