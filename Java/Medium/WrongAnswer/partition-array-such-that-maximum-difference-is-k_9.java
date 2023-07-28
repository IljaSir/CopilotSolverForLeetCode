class Solution {
    public int partitionArray(int[] nums, int k) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] min = new int[n];
        int[] max = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = i > 0 ? left[i - 1] + nums[i] : nums[i];
            min[i] = i > 0 ? Math.min(min[i - 1], nums[i]) : nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            right[i] = i < n - 1 ? right[i + 1] + nums[i] : nums[i];
            max[i] = i < n - 1 ? Math.max(max[i + 1], nums[i]) : nums[i];
        }
        int ans = 1;
        for (int i = 0; i < n - 1; i++) {
            if (max[i + 1] - min[i] <= k) {
                ans++;
                i++;
            }
        }
        return ans;
    }
}