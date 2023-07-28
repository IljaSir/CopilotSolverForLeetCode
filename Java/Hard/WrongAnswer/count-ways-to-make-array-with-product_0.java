class Solution {
    public int[] waysToFillArray(int[][] queries) {
        
        int mod = 1000000007;
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int n = queries[i][0];
            int k = queries[i][1];
            int[] dp = new int[k + 1];
            for (int j = 1; j <= k; j++) {
                dp[j] = j;
            }
            for (int j = 2; j <= n; j++) {
                int[] temp = new int[k + 1];
                for (int l = 1; l <= k; l++) {
                    for (int m = l; m <= k; m += l) {
                        temp[m] = (temp[m] + dp[l]) % mod;
                    }
                }
                dp = temp;
            }
            int sum = 0;
            for (int j = 1; j <= k; j++) {
                sum = (sum + dp[j]) % mod;
            }
            ans[i] = sum;
        }
        return ans;
    }
}