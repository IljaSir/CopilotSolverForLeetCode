class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int n = intervals.length;
        int[] dp = new int[n];
        dp[0] = 2;
        for (int i = 1; i < n; i++) {
            dp[i] = 2;
            for (int j = i - 1; j >= 0; j--) {
                if (intervals[j][1] >= intervals[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}