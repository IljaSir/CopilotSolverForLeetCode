class Solution {
    public int maxTwoEvents(int[][] events) {
        
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        int[] dp = new int[n];
        dp[0] = events[0][2];
        for (int i = 1; i < n; i++) {
            int val = events[i][2];
            int start = events[i][0];
            int end = events[i][1];
            int pos = find(events, start - 1);
            if (pos != -1) {
                val += dp[pos];
            }
            dp[i] = Math.max(val, dp[i - 1]);
        }
        return dp[n - 1];
    }
    
    private int find(int[][] events, int val) {
        int l = 0;
        int r = events.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (events[mid][1] <= val) {
                if (mid == events.length - 1 || events[mid + 1][1] > val) {
                    return mid;
                } else {
                    l = mid + 1;
                }
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}