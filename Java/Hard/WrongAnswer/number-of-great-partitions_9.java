class Solution {
    public int countPartitions(int[] nums, int k) {
        
        int[] count = new int[1001];
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            count[nums[i]]++;
        }
        int[] dp = new int[1001];
        dp[0] = 1;
        int sum = 0;
        for(int i = 1; i <= 1000; i++) {
            sum += count[i - 1];
            for(int j = sum; j >= count[i]; j--) {
                dp[j] = (dp[j] + dp[j - count[i]]) % 1000000007;
            }
        }
        int ans = 0;
        for(int i = k; i <= sum; i++) {
            ans = (ans + dp[i]) % 1000000007;
        }
        return ans;
    }
}