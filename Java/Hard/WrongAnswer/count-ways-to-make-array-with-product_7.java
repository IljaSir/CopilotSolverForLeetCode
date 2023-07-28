class Solution {
    public int[] waysToFillArray(int[][] queries) {
        
        int[] answer = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            answer[i] = waysToFillArray(queries[i][0], queries[i][1]);
        }
        return answer;
    }
    
    public int waysToFillArray(int n, int k){
        int M = 1000000007;
        int[] dp = new int[k+1];
        for(int i=1; i<=k; i++){
            dp[i] = k/i;
        }
        for(int i=2; i<=n; i++){
            int[] dp1 = new int[k+1];
            for(int j=1; j<=k; j++){
                for(int l=j; l<=k; l+=j){
                    dp1[j] = (dp1[j] + dp[l])%M;
                }
            }
            dp = dp1;
        }
        int ans = 0;
        for(int i=1; i<=k; i++){
            ans = (ans + dp[i])%M;
        }
        return ans;
    }
}