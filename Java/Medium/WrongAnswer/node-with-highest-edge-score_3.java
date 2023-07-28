class Solution {
    public int edgeScore(int[] edges) {
        
        int[] score = new int[edges.length];
        for (int i = 0; i < edges.length; i++) {
            score[edges[i]] += i;
        }
        int maxScore = 0;
        int maxScoreIndex = 0;
        for (int i = 0; i < score.length; i++) {
            if (score[i] > maxScore) {
                maxScore = score[i];
                maxScoreIndex = i;
            }
        }
        return maxScoreIndex;
    }
}