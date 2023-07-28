class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, n + 1);
        int[] pre = new int[n];
        Arrays.fill(pre, n + 1);
        int sum = 0;
        int l = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            while (sum > target) {
                sum -= arr[l];
                l++;
            }
            if (sum == target) {
                if (l > 0) {
                    dp[i] = i - l + 1;
                }
                if (l > 0 && pre[l - 1] != n + 1) {
                    dp[i] = Math.min(dp[i], pre[l - 1] + i - l + 1);
                }
            }
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1]);
            }
            pre[i] = dp[i];
        }
        return dp[n - 1] == n + 1 ? -1 : dp[n - 1];
    }
}