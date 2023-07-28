class Solution {
    public int connectTwoGroups(List<List<Integer>> cost) {
        
        int m = cost.size();
        int n = cost.get(0).size();
        int[][] dp = new int[m+1][1<<n];
        for(int i = 0; i <= m; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE/2);
        }
        dp[0][0] = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < (1<<n); j++){
                for(int k = 0; k < n; k++){
                    dp[i+1][j|(1<<k)] = Math.min(dp[i+1][j|(1<<k)], dp[i][j] + cost.get(i).get(k));
                }
            }
        }
        int ans = dp[m][(1<<n)-1];
        for(int i = 1; i < (1<<n); i++){
            int sum = 0;
            for(int j = 0; j < m; j++){
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < n; k++){
                    if(((i>>k)&1) == 1){
                        min = Math.min(min, cost.get(j).get(k));
                    }
                }
                sum += min;
            }
            ans = Math.min(ans, sum + dp[m][i]);
        }
        return ans;
    }
}