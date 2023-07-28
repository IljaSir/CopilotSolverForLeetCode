class Solution {
    public int maxFrequency(int[] nums, int k) {
        
        Arrays.sort(nums);
        int l = 0;
        long total = 0;
        int ans = 1;
        for (int r = 1; r < nums.length; ++r) {
            total += (long) (nums[r] - nums[r - 1]) * (r - l);
            while (total > k) {
                total -= nums[r] - nums[l];
                ++l;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}