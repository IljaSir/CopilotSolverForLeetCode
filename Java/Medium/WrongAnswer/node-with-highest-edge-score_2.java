class Solution {
    public int edgeScore(int[] edges) {
        
        int n = edges.length;
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[edges[i]]++;
        }
        int maxScore = 0;
        int maxIndex = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}