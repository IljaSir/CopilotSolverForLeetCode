class Solution {
    public long countBadPairs(int[] nums) {
        
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int j = i + nums[i];
            int k = Math.max(i - nums[i] - 1, 0);
            ans += (long) (j - k) * (j - k - 1) / 2;
        }
        return ans;
    }
}