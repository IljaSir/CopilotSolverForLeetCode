class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        
        int n = arr1.length;
        int m = arr2.length;
        Arrays.sort(arr2);
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = arr1[0];
        for (int i = 1; i < n; i++) {
            dp[i][i] = arr1[i];
            for (int j = 0; j < i; j++) {
                dp[i][j] = dp[i - 1][j];
                if (dp[i - 1][j] < arr1[i] && arr1[i] < arr1[i - 1]) {
                    dp[i][j] = arr1[i];
                }
                if (dp[i - 1][j] < arr1[i]) {
                    int index = Arrays.binarySearch(arr2, dp[i - 1][j]);
                    if (index < 0) {
                        index = -index - 1;
                    }
                    if (index < m) {
                        dp[i][j] = arr2[index];
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            if (dp[n - 1][j] != Integer.MAX_VALUE) {
                ans = Math.min(ans, j);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}