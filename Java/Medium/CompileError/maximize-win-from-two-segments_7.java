class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        
        int n = prizePositions.length;
        int] dp = new int[n];
        int i = 0, j = 0;
        int res = 0;
        while (j < n) {
            whie (j < n && prizePositions[j] - prizePositions[i <= k) {
               res = Math.max(res, +dp[j++]);
            }
            dp[i++]--;
        }
        return res;
    }
}