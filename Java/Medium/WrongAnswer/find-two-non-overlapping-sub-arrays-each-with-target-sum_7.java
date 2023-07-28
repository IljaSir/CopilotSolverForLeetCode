class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        
        int n = arr.length;
        int[] dp = new int[n];
        int sum = 0;
        int l = 0;
        int r = 0;
        int min = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        while (r < n) {
            sum += arr[r];
            while (sum > target) sum -= arr[l++];
            if (sum == target) {
                dp[r] = r - l + 1;
                if (l > 0 && dp[l - 1] > 0) {
                    res = Math.min(res, dp[l - 1] + dp[r]);
                }
                min = Math.min(min, dp[r]);
            }
            if (r > 0 && dp[r - 1] > 0) dp[r] = dp[r - 1];
            r++;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}