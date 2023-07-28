class Solution {
    public int maxJumps(int[] arr, int d) {
        
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= i + d && j < n && arr[j] < arr[i]; j++) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            for (int j = i - 1; j >= i - d && j >= 0 && arr[j] < arr[i]; j--) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}