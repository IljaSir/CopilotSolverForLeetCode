class Solution {
    public int maxTurbulenceSize(int[] arr) {
        
        int n = arr.length;
        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                dp[i][0] = dp[i][1] = 1;
            } else if (arr[i] > arr[i - 1]) {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = 1;
            } else {
                dp[i][0] = 1;
                dp[i][1] = dp[i - 1][0] + 1;
            }
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        return ans;
    }
}