class Solution {
    public long minimumReplacement(int[] nums) {
        
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                int diff = nums[i] - nums[i + 1];
                ans += (diff + 1) / 2;
                nums[i + 1] += ((diff + 1) / 2) * 2;
            }
        }
        return ans;
    }
}