class Solution {
    public int getMaxLen(int[] nums) {
        
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        if (nums[0] > 0) {
            dp1[0] = 1;
        } else if (nums[0] < 0) {
            dp2[0] = 1;
        }
        int max = dp1[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                dp1[i] = dp1[i - 1] + 1;
                if (dp2[i - 1] > 0) {
                    dp2[i] = dp2[i - 1] + 1;
                }
            } else if (nums[i] < 0) {
                if (dp2[i - 1] > 0) {
                    dp1[i] = dp2[i - 1] + 1;
                }
                dp2[i] = dp1[i - 1] + 1;
            }
            max = Math.max(max, dp1[i]);
        }
        return max;
    }
}