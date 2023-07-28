class Solution {
    public int squareFreeSubsets(int[] nums) {
        
        int n = nums.length;
        int mod = 1000000007;
        int[] dp = new int[1 << n];
        dp[0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < (1 << n); j++) {
                if(dp[j] == 0) {
                    continue;
                }
                if((j & (1 << i)) != 0) {
                    continue;
                }
                int product = 1;
                for(int k = i; k < n; k++) {
                    if((j & (1 << k)) != 0) {
                        continue;
                    }
                    product *= nums[k];
                    if(product > 30) {
                        break;
                    }
                    dp[j | (1 << k)] += dp[j];
                    dp[j | (1 << k)] %= mod;
                }
            }
        }
        int result = 0;
        for(int i = 0; i < (1 << n); i++) {
            if(Integer.bitCount(i) % 2 == 1) {
                result += dp[i];
            } else {
                result -= dp[i];
            }
            result %= mod;
        }
        if(result < 0) {
            result += mod;
        }
        return result;
    }
}