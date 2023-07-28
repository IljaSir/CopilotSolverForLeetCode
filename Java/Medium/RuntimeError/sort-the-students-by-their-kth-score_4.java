class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        
        int[][] result = new int[score.length][score[0].length];
        int[] temp = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            temp[i] = score[i][k];
        }
        Arrays.sort(temp);
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[0].length; j++) {
                result[i][j] = score[findIndex(score, temp[i])][j];
            }
        }
        return result;
    }
    
    public int findIndex(int[][] score, int target) {
        int result = -1;
        for (int i = 0; i < score.length; i++) {
            if (score[i][0] == target) {
                result = i;
                break;
            }
        }
        return result;
    }
}