class Solution {
    public int countPartitions(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n+1];
        int[] sum = new int[n+1];
        dp[0] = 1;
        for(int i=0; i<n; i++){
            sum[i+1] = sum[i] + nums[i];
            for(int j=i; j>=0; j--){
                if(sum[i+1] - sum[j] >= k){
                    dp[i+1] = (dp[i+1] + dp[j]) % 1000000007;
                }
            }
        }
        return dp[n];
    }
}