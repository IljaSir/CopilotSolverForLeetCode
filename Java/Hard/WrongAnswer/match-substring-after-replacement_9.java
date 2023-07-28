class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        
        int m = s.length();
        int n = sub.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == sub.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    for(char[] mapping : mappings){
                        if(s.charAt(i-1) == mapping[0] && sub.charAt(j-1) == mapping[1]){
                            dp[i][j] = dp[i-1][j-1];
                            break;
                        }
                    }
                }
            }
        }
        return dp[m][n] == 1;
    }
}