class Solution {
    public int edgeScore(int[] edges) {
        
        int n = edges.length;
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            degree[edges[i]]++;
        }
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[edges[i]] += i;
        }
        int max = 0, maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                continue;
            }
            if (score[i] > max) {
                max = score[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}