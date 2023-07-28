class Solution {
    public int kSimilarity(String s1, String s2) {
        
        if(s1.equals(s2)) return 0;
        int n = s1.length();
        int[] A = new int[n];
        int[] B = new int[n];
        int l = 0;
        for(int i=0;i<n;i++){
            if(s1.charAt(i) != s2.charAt(i)){
                A[l] = s1.charAt(i) - 'a';
                B[l] = s2.charAt(i) - 'a';
                l++;
            }
        }
        int[][] dp = new int[l][1<<l];
        for(int[] d : dp){
            Arrays.fill(d, 10000);
        }
        for(int i=0;i<l;i++){
            dp[i][1<<i] = 1;
        }
        for(int i=0;i<l;i++){
            for(int j=0;j<(1<<l);j++){
                for(int k=0;k<l;k++){
                    if((j & (1<<k)) == 0){
                        if(A[i] == A[k] || A[i] == B[k]){
                            dp[k][j | (1<<k)] = Math.min(dp[k][j | (1<<k)], dp[i][j] + 1);
                        }
                    }
                }
            }
        }
        int ans = 10000;
        for(int i=0;i<l;i++){
            ans = Math.min(ans, dp[i][(1<<l)-1]);
        }
        return ans;
    }
}