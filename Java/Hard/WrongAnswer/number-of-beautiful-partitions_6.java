class Solution {
    public int beautifulPartitions(String s, int k, int minLength) {
        
        int n = s.length();
        int[][] dp = new int[n+1][k+1];
        int[][] primes = new int[n+1][n+1];
        int[][] nonPrimes = new int[n+1][n+1];
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(isPrime(s.charAt(j))){
                    primes[i][j] = 1;
                }else{
                    nonPrimes[i][j] = 1;
                }
            }
        }
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                for(int l = minLength; l <= i; l++){
                    if(primes[i-l][i-1] == 1 && nonPrimes[i-l][i-1] == 1){
                        dp[i][j] += dp[i-l][j-1];
                    }
                }
            }
        }
        return dp[n][k];
    }
    private boolean isPrime(char c){
        if(c == '2' || c == '3' || c == '5' || c == '7'){
            return true;
        }
        return false;
    }
}