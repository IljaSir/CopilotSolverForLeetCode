class Solution {
    public int minimumDistance(String word) {
        
        int[][][] dp = new int[word.length()][27][27];
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < 27; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        return minDistance(word, 0, 26, 26, dp);
    }
    
    private int minDistance(String word, int index, int left, int right, int[][][] dp) {
        if (index == word.length()) {
            return 0;
        }
        if (dp[index][left][right] != Integer.MAX_VALUE) {
            return dp[index][left][right];
        }
        int l = getDistance(left, word.charAt(index) - 'A');
        int r = getDistance(right, word.charAt(index) - 'A');
        int res = Integer.MAX_VALUE;
        res = Math.min(res, minDistance(word, index + 1, word.charAt(index) - 'A', right, dp) + l);
        res = Math.min(res, minDistance(word, index + 1, left, word.charAt(index) - 'A', dp) + r);
        dp[index][left][right] = res;
        return res;
    }
    
    private int getDistance(int a, int b) {
        if (a == 26) {
            return 0;
        }
        return Math.abs(a / 6 - b / 6) + Math.abs(a % 6 - b % 6);
    }
}