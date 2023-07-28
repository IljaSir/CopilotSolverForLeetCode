class Solution {
    public int maxTurbulenceSize(int[] arr) {
        
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                dp[i] = (i - 2 >= 0 && arr[i - 1] < arr[i - 2]) ? dp[i - 1] + 1 : 2;
            } else if (arr[i] < arr[i - 1]) {
                dp[i] = (i - 2 >= 0 && arr[i - 1] > arr[i - 2]) ? dp[i - 1] + 1 : 2;
            } else {
                dp[i] = 1;
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}