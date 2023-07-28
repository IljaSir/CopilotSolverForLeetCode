class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        
        int n = board.size();
        int[][] dp = new int[n][n];
        int[][] paths = new int[n][n];
        int mod = 1000000007;
        dp[n-1][n-1] = 0;
        paths[n-1][n-1] = 1;
        for(int i = n-2; i>=0; i--){
            if(board.get(i).charAt(n-1) != 'X'){
                dp[i][n-1] = dp[i+1][n-1] + board.get(i).charAt(n-1) - '0';
                paths[i][n-1] = 1;
            }
        }
        for(int j = n-2; j>=0; j--){
            if(board.get(n-1).charAt(j) != 'X'){
                dp[n-1][j] = dp[n-1][j+1] + board.get(n-1).charAt(j) - '0';
                paths[n-1][j] = 1;
            }
        }
        for(int i = n-2; i>=0; i--){
            for(int j = n-2; j>=0; j--){
                if(board.get(i).charAt(j) == 'X') continue;
                int max = Math.max(dp[i+1][j], Math.max(dp[i][j+1], dp[i+1][j+1]));
                if(max == dp[i+1][j]) paths[i][j] = (paths[i][j] + paths[i+1][j])%mod;
                if(max == dp[i][j+1]) paths[i][j] = (paths[i][j] + paths[i][j+1])%mod;
                if(max == dp[i+1][j+1]) paths[i][j] = (paths[i][j] + paths[i+1][j+1])%mod;
                dp[i][j] = max + board.get(i).charAt(j) - '0';
            }
        }
        return new int[]{dp[0][0], paths[0][0]};
    }
}