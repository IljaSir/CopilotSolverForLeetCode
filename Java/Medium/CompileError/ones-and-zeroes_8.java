class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        
        int[][] dp = new int[m+1][n+1];
        for(String s: strs) {
            int[] count = count(s);
            for(int i = m; i >= count[0]; i--) {
                for(int j = n; j >= count[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count[0]][j - count[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }
    
    private int[] count(String s) {
        int[] res = new int[2];
        for(int i = 0; i < s.length(); i++) {
            res[s.charAt(i) - '0']++;
        }
        return res int[2];
        for (char c : s.toCharArray()) {
            res[c - '0']++;
        }
        return res;
    }
}