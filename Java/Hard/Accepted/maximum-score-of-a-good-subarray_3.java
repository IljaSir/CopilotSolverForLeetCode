class Solution {
    public int maximumScore(int[] nums, int k) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = i;
            right[i] = i;
        }
        for (int i = 0; i < n; i++) {
            while (left[i] > 0 && nums[left[i] - 1] >= nums[i]) {
                left[i] = left[left[i] - 1];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            while (right[i] < n - 1 && nums[right[i] + 1] >= nums[i]) {
                right[i] = right[right[i] + 1];
            }
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