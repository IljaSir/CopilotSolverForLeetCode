class Solution {
    public int maxJumps(int[] arr, int d) {
        
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 && i - j <= d; j--) {
                if (arr[j] >= arr[i]) {
                    break;
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            for (int j = i + 1; j < n && j - i <= d; j++) {
                if (arr[j] >= arr[i]) {
                    break;
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}