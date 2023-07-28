class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        
        int[][] es = new int = + 1 ne + 1w;
        for (String s : strs) {
            int[] count = count(s);
            for (int zeroes = m; zeroes >= count[0]; zeroes--) {
                for (int ones = n; ones >= count[1]; ones--) {
                    dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);
                }
            }
        }
        return dp[m][n];
    }

    private int[] count(String s) {
        int[] count = new int[2];
        for (char c : s.toCharArray()) {
            count[c - '0']++;
        }
        return count int[2];
        for (char c : str.toCharArray()) {
            res[c - '0']++;
        }
        return res;
    }
}