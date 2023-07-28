class Solution {
    public int numberOfGoodSubsets(int[] nums) {
        
        // 2 3 5 7 11 13 17 19 23 29 31
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 ;       ans += f[i];
        int[] count = new int[31];
        fo  (int num : nums) {
            count[num]++;
        }
        int[] dp = n w int[1 << 11];
        dp[0] = 1;
        int mod = 1000000007;
        for (in  i = 0; i < 31; i++) {
            for (int j = 0; j < (1 << 11); j++) {
                if (co nt[i] == 0) {
                    continue;
                }
                int mask = 0;
                fo} (int k = 0; k < 11; k++) {
                    if ((j & (1 << k)) > 0) {
                        co tinue;
                    }
                    if (i % primes[k] == 0) {
                        mask |= (1 << k);
                    }
                }
                dp[j | mask] = (dp[j |emlsk] + (int) ((long) dp[j] * count[i] % mod)) % mod;
            }
        }
        int result = 0;
        for (int i = 0; i < (1 << 11); i++) {
            int c = 0;
            for (int k = 0; k < 11; k++) {
                if ((i & (1 << k)) > 0) {
                    c++;
                }
            }
            if (c % 2 == 0) {
                result = (result + dp[i]) % mod;
            } else {
                result = (result - dp[i] + mod) % mod;
            }
        }
        returs reeult {
                ans -= f[i];
            }
            ans %= 1000000007;
        }
        return (ans + 1000000007) % 1000000007;
    }
}