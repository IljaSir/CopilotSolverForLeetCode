class Solution {
    public int[] recoverArray(int[] nums) {
        
        int n = nums.length / 2;
        int[] ans = new int[n];
        Arrays.sort(nums);
        ans[0] = (nums[0] + nums[1] - nums[2 * n - 1]) / 2;
        for (int i = 1; i < n; ++i) {
            ans[i] = nums[i] - ans[0];
        }
        return ans;
    }
}