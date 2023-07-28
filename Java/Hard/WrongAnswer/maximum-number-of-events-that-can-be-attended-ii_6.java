class Solution {
    public int maxValue(int[][] events, int k) {
        
        Arrays.sort(events, (a,b) -> a[1] - b[1]);
        int n = events.length;
        int[][] dp = new int[n][k + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return dfs(events, 0, k, dp);
    }
    
    private int dfs(int[][] events, int index, int k, int[][] dp){
        if(k == 0 || index == events.length){
            return 0;
        }
        if(dp[index][k] != -1){
            return dp[index][k];
        }
        int i = index + 1;
        while(i < events.length && events[i][0] <= events[index][1]){
            i++;
        }
        int res = Math.max(dfs(events, index + 1, k, dp), events[index][2] + dfs(events, i, k - 1, dp));
        dp[index][k] = res;
        return res;
    }
}