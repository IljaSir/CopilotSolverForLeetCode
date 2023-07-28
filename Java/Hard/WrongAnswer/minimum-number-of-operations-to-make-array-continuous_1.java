class Solution {
    public int minOperations(int[] nums) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int ans = n;
        for (int i = 0, j = 0; i < n; ++i) {
            while (j < n && nums[j] - nums[i] <= n - 1) {
                ++j;
            }
            ans = Math.min(ans, n - (j - i));
        }
        return ans;
    }
}