class Solution {
    public long countBadPairs(int[] nums) {
        
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j - i != nums[j] - nums[i]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}