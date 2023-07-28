class Solution {
    public long minimumReplacement(int[] nums) {
        
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                if (i + 1 < nums.length && nums[i + 1] % 2 == 1) {
                    i++;
                }
                ans++;
            }
        }
        return ans;
    }
}