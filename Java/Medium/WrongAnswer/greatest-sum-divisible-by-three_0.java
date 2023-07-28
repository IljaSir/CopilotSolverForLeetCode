class Solution {
    public int maxSumDivThree(int[] nums) {
        
        int[] dp = new int[3];
        for (int num : nums) {
            int[] ndp = new int[3];
            for (int i = 0; i < 3; i++) {
                ndp[(num + i) % 3] = Math.max(dp[(num + i) % 3], dp[i] + num);
            }
            dp = ndp;
        }
        return dp[0];
    }
}