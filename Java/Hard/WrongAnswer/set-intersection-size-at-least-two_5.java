class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 2);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] >= intervals[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + (intervals[i][1] <= intervals[j][1] ? 0 : 1));
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}