class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        
        int n = score.length;
        int m = score[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n - i - 1; ++j) {
                if (score[j][k] < score[j + 1][k]) {
                    int[] tmp = score[j];
                    score[j] = score[j + 1];
                    score[j + 1] = tmp;
                }
            }
        }
        return score;
    }
}