class Solution {
    public int numberOfGoodSubsets(int[] nums) {
        
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        int[] count = new int[32];
        for (int num : nums) {
            for (int p : prime) {
                if (num % p == 0) {
                    count[p]++;
                    break;
                }
            }
        }
        int[] dp = new int[1 << 11];
        dp[0] = 1;
        for (int i = 0; i < 11; i++) {
            int p = prime[i];
            int[] next = dp.clone();
            for (int j = 0; j < (1 << 11); j++) {
                if (dp[j] == 0) continue;
                for (int k = 1; k <= count[p]; k++) {
                    next[j | (1 << i)] += dp[j];
                    next[j | (1 << i)] %= 1000000007;
                }
            }
            dp = next;
        }
        int ans = 0;
        for (int i = 1; i < (1 << 11); i++) {
            int c = 0;
            for (int j = 0; j < 11; j++) {
                if ((i & (1 << j)) > 0) c++;
            }
            if (c % 2 == 1) ans -= dp[i];
            else ans += dp[i];
            ans %= 1000000007;
        }
        ans += 1000000007;
        ans %= 1000000007;
        return ans;
    }
}