class Solution {
    public int[] waysToFillArray(int[][] queries) {
        
        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int n = queries[i][0];
            int k = queries[i][1];
            res[i] = helper(n,k);
        }
        return res;
    }
    public int helper(int n, int k){
        int mod = 1000000007;
        int[] dp = new int[k+1];
        for(int i=1;i<=k;i++){
            dp[i] = k/i;
        }
        for(int i=2;i<=n;i++){
            int[] temp = new int[k+1];
            for(int j=1;j<=k;j++){
                for(int l=1;l*j<=k;l++){
                    temp[j*l] = (temp[j*l] + dp[j])%mod;
                }
            }
            dp = temp;
        }
        int sum = 0;
        for(int i=1;i<=k;i++){
            sum = (sum + dp[i])%mod;
        }
        return sum;
    }
}