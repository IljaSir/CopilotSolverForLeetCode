class Solution {
    public int[] waysToFillArray(int[][] queries) {
        
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int n = queries[i][0];
            int k = queries[i][1];
            int[] dp = new int[k + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int j = 2; j <= k; j++) {
                int temp = 0;
                for (int l = 1; l * l <= j; l++) {
                    if (j % l == 0) {
                        temp += dp[l];
                        if (l * l != j) {
                            temp += dp[j / l];
                        }
                    }
                }
                dp[j] = temp % 1000000007;
            }
            result[i] = dp[k];
        }
        return result;
    }
}