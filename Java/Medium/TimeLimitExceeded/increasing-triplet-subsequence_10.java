class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            int count = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    count = Math.max(count, dp[j] + 1);
                }
            }
            dp[i] = count;
            max = Math.max(max, count);
            if (max >= 3) {
                return true;
            }
        }
        return false;
    }
}