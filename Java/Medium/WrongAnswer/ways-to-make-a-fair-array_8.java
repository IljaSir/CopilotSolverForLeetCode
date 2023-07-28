class Solution {
    public int waysToMakeFair(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[n][2];
        int res = 0;
        for(int i = 0; i < n; i++){
            dp[i][0] += nums[i];
            if(i > 0){
                dp[i][0] += dp[i - 1][1];
            }
            dp[i][1] += dp[i][0];
            if(i > 0){
                dp[i][1] -= nums[i - 1];
            }
        }
        for(int i = 0; i < n; i++){
            int even = 0, odd = 0;
            if(i - 1 >= 0){
                even += dp[i - 1][1];
                odd += dp[i - 1][0];
            }
            if(i + 1 < n){
                even += dp[n - 1][1] - dp[i][1];
                odd += dp[n - 1][0] - dp[i][0];
            }
            if(even == odd){
                res++;
            }
        }
        return res;
    }
}