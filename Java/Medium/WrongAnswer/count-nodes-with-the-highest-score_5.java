class Solution {
    public int countHighestScoreNodes(int[] parents) {
        
        int n = parents.length;
        int[] count = new int[n];
        int[] score = new int[n];
        int maxScore = 0;
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            count[i] = 1;
            score[i] = 1;
            int p = parents[i];
            if (p != -1) {
                count[p] += count[i];
                score[p] *= count[i];
            }
            if (score[i] > maxScore) {
                maxScore = score[i];
                res = count[i];
            } else if (score[i] == maxScore) {
                res += count[i];
            }
        }
        return res;
    }
}