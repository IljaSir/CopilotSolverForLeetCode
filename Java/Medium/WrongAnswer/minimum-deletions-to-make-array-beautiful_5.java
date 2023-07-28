class Solution {
    public int minDeletion(int[] nums) {
        
        int ans = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                ans++;
            } else {
                prev = nums[i];
            }
        }
        return ans;
    }
}