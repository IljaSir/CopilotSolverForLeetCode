class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        
        int n = piles.size();
        int m = piles.get(0).size();
        int[][] dp = new int[n][k+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= k; j++){
                dp[i][j] = -1;
            }
        }
        return maxValueOfCoins(piles, 0, 0, k, dp);
    }
    private int maxValueOfCoins(List<List<Integer>> piles, int i, int j, int k, int[][] dp){
        if(k == 0){
            return 0;
        }
        if(i >= piles.size()){
            return 0;
        }
        if(dp[i][k] != -1){
            return dp[i][k];
        }
        List<Integer> pile = piles.get(i);
        int ans = 0;
        int n = pile.size();
        if(j < n){
            ans = Math.max(ans, pile.get(j) + maxValueOfCoins(piles, i, j+1, k-1, dp));
        }
        if(j < n - 1){
            ans = Math.max(ans, pile.get(n - 1 - j) + maxValueOfCoins(piles, i+1, j, k-1, dp));
        }
        dp[i][k] = ans;
        return ans;
    }
}