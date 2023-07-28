class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int[] dp = new int[n];
        Arrays.fill(dp, 2);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (intervals[i][0] <= intervals[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}