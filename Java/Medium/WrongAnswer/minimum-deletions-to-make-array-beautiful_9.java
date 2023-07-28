class Solution {
    public int minDeletion(int[] nums) {
        
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i < n; i += 2) {
            if (nums[i-1] == nums[i]) {
                ans++;
                if (i+1 < n && nums[i-1] == nums[i+1]) {
                    nums[i] = -1;
                }
            }
        }
        return ans;
    }
}