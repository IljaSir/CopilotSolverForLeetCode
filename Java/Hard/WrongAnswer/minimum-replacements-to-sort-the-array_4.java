class Solution {
    public long minimumReplacement(int[] nums) {
        
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] % 2 == 0) {
                continue;
            }
            ++ans;
            if (i < n - 1 && nums[i + 1] % 2 == 1) {
                ++i;
            }
        }
        return ans;
    }
}