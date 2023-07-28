class Solution {
    public int minCost(int n, int[] cuts) {
        
        int[] arr = new int[cuts.length+2];
        for (int i = 0; i < cuts.length; i++) {
            arr[i+1] = cuts[i];
        }
        arr[0] = 0;
        arr[arr.length-1] = n;
        Arrays.sort(arr);
        int[][] dp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(arr, dp, 0, arr.length-1);
    }
    
    public int helper(int[] arr, int[][] dp, int i, int j) {
        if (j-i == 1) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i+1; k < j; k++) {
            min = Math.min(min, helper(arr, dp, i, k) + helper(arr, dp, k, j) + arr[j] - arr[i]);
        }
        dp[i][j] = min;
        return min;
    }
}