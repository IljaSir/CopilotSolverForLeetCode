class Solution {
    public int halveArray(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for(int i = 0; i < n; i++){
            for(int j = target; j >= 0; j--){
                if(j >= nums[i]){
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }
        }
        int half = dp[target];
        return (int)Math.ceil((sum - half) / (double)half);
    }
}