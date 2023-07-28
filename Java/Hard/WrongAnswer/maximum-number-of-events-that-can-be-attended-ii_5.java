class Solution {
    public int maxValue(int[][] events, int k) {
        
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int[] dp = new int[n+1];
        for(int i = 1; i <= k; i++) {
            int[] ndp = new int[n+1];
            int prev = 0;
            for(int j = 1; j <= n; j++) {
                ndp[j] = Math.max(ndp[j-1], dp[j]);
                int l = j-1;
                int r = j;
                while(l < r) {
                    int mid = (l+r)/2;
                    if(events[mid][1] < events[j-1][0]) l = mid+1;
                    else r = mid;
                }
                ndp[j] = Math.max(ndp[j], dp[l] + events[j-1][2]);
            }
            dp = ndp;
        }
        return dp[n];
    }
}