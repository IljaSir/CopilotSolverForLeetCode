class Solution {
    public int maxTwoEvents(int[][] events) {
        
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int[] dp = new int[n];
        dp[0] = events[0][2];
        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1], events[i][2]);
            int l = 0, r = i-1;
            while(l <= r) {
                int mid = l + (r - l)/2;
                if(events[mid][1] < events[i][0]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if(r >= 0) {
                dp[i] = Math.max(dp[i], dp[r] + events[i][2]);
            }
        }
        return dp[n-1];
    }
}