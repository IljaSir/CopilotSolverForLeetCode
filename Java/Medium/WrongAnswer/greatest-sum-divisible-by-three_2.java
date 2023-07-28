class Solution {
    public int maxSumDivThree(int[] nums) {
        
        int[] dp = new int[3];
        for (int num : nums) {
            int[] tmp = new int[3];
            for (int i = 0; i < 3; i++) {
                tmp[(num + dp[i]) % 3] = Math.max(tmp[(num + dp[i]) % 3], num + dp[i]);
            }
            dp = tmp;
        }
        return dp[0];
    }
}