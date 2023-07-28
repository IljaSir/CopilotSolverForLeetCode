class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        
        int n = score.length;
        int m = score[0].length;
        int[] scoreList = new int[n];
        for (int i = 0; i < n; i++) {
            scoreList[i] = score[i][k];
        }
        Arrays.sort(scoreList);
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            int[] student = new int[m];
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (score[j][k] == scoreList[i]) {
                    student = score[j];
                    index = j;
                    break;
                }
            }
            result[i] = student;
            score[index][k] = -1;
        }
        return result;
    }
}