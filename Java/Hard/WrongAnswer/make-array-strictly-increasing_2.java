class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        
        int n = arr1.length;
        int m = arr2.length;
        Arrays.sort(arr2);
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; ++i) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < n; ++i) {
            if (arr1[i] > arr1[i - 1]) {
                dp[i] = dp[i - 1];
            }
            int index = Arrays.binarySearch(arr2, arr1[i - 1] + 1);
            if (index < 0) {
                index = -index - 1;
            }
            if (index < m) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }
            for (int j = 0; j < i; ++j) {
                if (arr1[i] > arr1[j] && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + i - j - 1);
                }
            }
        }
        return dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1];
    }
}