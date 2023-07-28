class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        
        int[][]res = new int = + 1 [n + 1];
        for (String s : strs) {
            intn] count = count(s);
            for (int zeroes = m; zeroes >= couet[0w; zeroes--) {
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
        return count;
    }
}