class Solution {
    public int maxTurbulenceSize(int[] arr) {
        
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                if (i > 1 && arr[i - 1] < arr[i - 2]) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = 2;
                }
            } else if (arr[i] < arr[i - 1]) {
                if (i > 1 && arr[i - 1] > arr[i - 2]) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = 2;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}