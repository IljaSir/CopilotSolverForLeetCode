class Solution {
    public int numTeams(int[] rating) {
        
        int n = rating.length;
        int[][] less = new int[n][n];
        int[][] greater = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rating[i] < rating[j]) {
                    less[i][j] = 1;
                    greater[j][i] = 1;
                } else if (rating[i] > rating[j]) {
                    greater[i][j] = 1;
                    less[j][i] = 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans += less[i][j] * greater[j][i];
                ans += greater[i][j] * less[j][i];
            }
        }
        return ans;
    }
}