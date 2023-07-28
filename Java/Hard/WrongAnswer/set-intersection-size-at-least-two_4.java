class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int n = intervals.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 2);
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (intervals[j][0] > intervals[i][1]) {
                    break;
                }
                dp[i] = Math.max(dp[i], dp[j] + (intervals[j][1] - intervals[i][1] == 1 ? 1 : 0));
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}