class Solution {
    public long countBadPairs(int[] nums) {
        
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && nums[j] - nums[i] < j - i) {
                j++;
            }
            ans += j - i - 1;
        }
        return ans;
    }
}