class Solution {
    public long minimumReplacement(int[] nums) {
        
        long ans = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 == 0) {
                continue;
            }
            if (i == len - 1 || nums[i + 1] % 2 == 0) {
                ans++;
            } else {
                ans += 2;
                i++;
            }
        }
        return ans;
    }
}