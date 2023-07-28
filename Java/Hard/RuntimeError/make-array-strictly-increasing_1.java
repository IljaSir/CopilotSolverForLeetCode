class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        
        Arrays.sort(arr2);
        int n = arr1.length;
        int m = arr2.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr1[j] < arr1[i]) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
                if (arr1[j] < arr2[i]) {
                    int index = Arrays.binarySearch(arr2, arr1[j]);
                    if (index < 0) {
                        index = -index - 1;
                    }
                    if (index < m) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
            if (dp[i] == Integer.MAX_VALUE) {
                int index = Arrays.binarySearch(arr2, arr1[i]);
                if (index < 0) {
                    index = -index - 1;
                }
                if (index < m) {
                    dp[i] = Math.min(dp[i], 1);
                }
            }
        }
        return dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1];
    }
}