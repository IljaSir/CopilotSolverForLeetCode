class Solution {
    public int countWays(int[][] ranges) {
        
        int n = ranges.length;
        long MOD = 1000000007;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++){
            start[i] = ranges[i][0];
            end[i] = ranges[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        long[] dp = new long[n+1];
        dp[0] = 1;
        int s = 0, e = 0;
        for(int i = 0; i < n; i++){
            while(s < n && start[s] <= end[i]) s++;
            while(e < n && end[e] < start[i]) e++;
            dp[i+1] = dp[i] * (s - e + 1) % MOD;
        }
        return (int)dp[n]-1;
    }
}