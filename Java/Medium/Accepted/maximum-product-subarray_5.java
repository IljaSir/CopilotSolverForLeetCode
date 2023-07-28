class Solution {
    public int maxProduct(int[] nums) {
        
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = max;
            int mn = min;
            max = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            min = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(max, ans);
        }
        return ans;
    }
}