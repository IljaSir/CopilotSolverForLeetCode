class Solution {
    public int numberOfGoodSubsets(int[] nums) {
        
        int MOD = (int)1e9+7;
        int[] cnt = new int[31];
        for (int x: nums) {
            cnt[x]++;
        }
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int[] dp = new int[1<<10];
        dp[0] = 1;
        for (int p: primes) {
            int[] ndp = new int[1<<10];
            for (int i = 0; i < 1<<10; i++) {
                if (dp[i] == 0) {
                    continue;
                }
                int j = i;
                int c = 1;
                while (c <= cnt[p]) {
                    ndp[j] = (ndp[j] + dp[i] * c) % MOD;
                    j |= 1 << (p-2);
                    c++;
                }
            }
            dp = ndp;
        }
        int ans = 0;
        for (int i = 0; i < 1<<10; i++) {
            int c = 1;
            for (int p: primes) {
                if ((i & 1 << (p-2)) > 0) {
                    c *= p;
                }
            }
            int sign = Integer.bitCount(i) % 2 == 0 ? 1 : -1;
            ans = (ans + sign * dp[i] * cnt[c]) % MOD;
        }
        return (ans + MOD) % MOD;
    }
}