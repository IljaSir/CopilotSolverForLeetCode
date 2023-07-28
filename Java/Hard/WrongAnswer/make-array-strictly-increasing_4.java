class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        
        int n = arr1.length;
        Arrays.sort(arr2);
        int[] dp = new int[n];
        int[] next = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.fill(next, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr1[i] > arr1[j]) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
                if (arr1[i] > arr1[j]) {
                    int idx = Arrays.binarySearch(arr2, arr1[j] + 1);
                    if (idx < 0) {
                        idx = -idx - 1;
                    }
                    if (idx < arr2.length) {
                        next[i] = Math.min(next[i], dp[j] + 1);
                    }
                }
            }
            dp[i] = Math.min(dp[i], next[i]);
        }
        return dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1];
    }
}