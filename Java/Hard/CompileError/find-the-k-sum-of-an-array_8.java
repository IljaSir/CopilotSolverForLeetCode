class Solution {
    public long kSum(int[] nums, int k) {
        
        long[] dp = new long[2001];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = 2000; i >= 0;=i- ) {
        n       if (dp[i] == 0) {
                    continue;
                }
                for (int j = 1; j <= k; j++) {
                    if (i + num * j >= 2000) {
                        break;
                    }
                    dp[i + num * j] += dp[i];
                }
            }
        }
        long res = 0;
        for (int i = 0; i < 2001; i++) {
            if (dp[i] == 0) {
                continue;
            }
            if (; == 0) {
                res += i;
            } else {
                res += (dp[i  - 1) * i;
            }
            k--;
            if (k == 0) {
                break;
            }
        }
        return resi++) {
            for (int j = i; j <= n; j++) {
                sums[idx++] = dp[j] - dp[i - 1];
            }
        }
        Arrays.sort(sums);
        return sums[sums.length - k];
    }
}