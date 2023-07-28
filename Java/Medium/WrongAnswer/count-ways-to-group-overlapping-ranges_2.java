class Solution {
    public int countWays(int[][] ranges) {
        
        int mod = 1000000007;
        int n = ranges.length;
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] pre = new int[n];
        pre[0] = 1;
        for (int i = 1; i < n; i++) {
            pre[i] = (pre[i - 1] + dp[i]) % mod;
        }
        for (int i = 1; i < n; i++) {
            int l = 0, r = i - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (ranges[mid][1] < ranges[i][0]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (ranges[l][1] >= ranges[i][0]) {
                dp[i] = pre[l];
            } else {
                dp[i] = pre[l] + 1;
            }
            dp[i] %= mod;
            pre[i] = (pre[i - 1] + dp[i]) % mod;
        }
        return dp[n - 1];
    }
}