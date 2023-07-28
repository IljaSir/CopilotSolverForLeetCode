class Solution {
    public int closestToTarget(int[] arr, int target) {
        
        int res = Integer.MAX_VALUE;
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
            res = Math.min(res, Math.abs(dp[i] - target));
            for (int j = i - 1; j >= 0; j--) {
                dp[j] &= arr[i];
                res = Math.min(res, Math.abs(dp[j] - target));
            }
        }
        return res;
    }
}