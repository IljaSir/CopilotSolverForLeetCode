class Solution {
    public int countHighestScoreNodes(int[] parents) {
        
        int n = parents.length;
        int[] childCount = new int[n];
        int[] score = new int[n];
        int maxScore = 0;
        int maxScoreCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            childCount[i]++;
            if (parents[i] != -1) {
                childCount[parents[i]] += childCount[i];
                score[parents[i]] += score[i] + childCount[i];
            }
            if (score[i] > maxScore) {
                maxScore = score[i];
                maxScoreCount = 1;
            } else if (score[i] == maxScore) {
                maxScoreCount++;
            }
        }
        return maxScoreCount;
    }
}