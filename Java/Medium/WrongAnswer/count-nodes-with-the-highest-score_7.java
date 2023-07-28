class Solution {
    public int countHighestScoreNodes(int[] parents) {
        
        int n = parents.length;
        int[] subtreeSize = new int[n];
        int[] score = new int[n];
        int maxScore = 0;
        for (int i = n - 1; i >= 0; i--) {
            subtreeSize[i]++;
            if (parents[i] != -1) {
                subtreeSize[parents[i]] += subtreeSize[i];
            }
            score[i] = subtreeSize[i];
            if (parents[i] != -1) {
                score[parents[i]] *= score[i];
            }
            maxScore = Math.max(maxScore, score[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (score[i] == maxScore) {
                res++;
            }
        }
        return res;
    }
}