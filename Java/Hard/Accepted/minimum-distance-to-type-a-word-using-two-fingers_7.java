class Solution {
    public int minimumDistance(String word) {
        
        int[][][] dp = new int[27][27][word.length()];
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        return dfs(word, 0, 26, 26, dp);
    }

    private int dfs(String word, int index, int left, int right, int[][][] dp) {
        if (index == word.length()) {
            return 0;
        }
        if (dp[left][right][index] != Integer.MAX_VALUE) {
            return dp[left][right][index];
        }
        int l = getDistance(left, word.charAt(index) - 'A');
        int r = getDistance(right, word.charAt(index) - 'A');
        int ans = Math.min(dfs(word, index + 1, word.charAt(index) - 'A', right, dp) + l,
                dfs(word, index + 1, left, word.charAt(index) - 'A', dp) + r);
        dp[left][right][index] = ans;
        return ans;
    }

    private int getDistance(int a, int b) {
        if (a == 26) {
            return 0;
        }
        int x1 = a / 6;
        int y1 = a % 6;
        int x2 = b / 6;
        int y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}