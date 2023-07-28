class Solution {
    public int squareFreeSubsets(int[] nums) {
        
        int mod = 1000000007;
        int n = nums.length;
        int[] dp = new int[1 << n];
        dp[0] = 1;
        int[] cnt = new int[31];
        for (int num : nums) {
            cnt[num]++;
        }
        int ans = 0;
        for (int mask = 1; mask < (1 << n); mask++) {
            int num = 1;
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    num *= nums[i];
                }
            }
            int c = Integer.bitCount(mask);
            if (c % 2 == 1) {
                ans = (ans + dp[mask]) % mod;
            } else {
                ans = (ans - dp[mask] + mod) % mod;
            }
            for (int i = 2; i * i <= num; i++) {
                if (num % (i * i) == 0) {
                    dp[mask] = 0;
                    break;
                }
            }
            if (dp[mask] != 0) {
                for (int i = 1; i <= 30; i++) {
                    if (cnt[i] != 0) {
                        int newMask = mask;
                        while (num % i == 0) {
                            num /= i;
                            newMask = newMask | (1 << (n + i - 1));
                        }
                        dp[newMask] = (dp[newMask] + dp[mask]) % mod;
                    }
                }
            }
        }
        return ans;
    }
}