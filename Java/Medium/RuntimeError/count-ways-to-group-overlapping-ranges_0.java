class Solution {
    public int countWays(int[][] ranges) {
        
        int MOD = 1000000007;
        int n = ranges.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = ranges[i][0];
            end[i] = ranges[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = (int) ((2L * dp[i - 1] - dp[binarySearch(end, start[i - 1]) - 1] + MOD) % MOD);
        }
        return dp[n];
    }

    private int binarySearch(int[] end, int target) {
        int l = 0, r = end.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (end[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}