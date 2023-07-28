class Solution {
    public int edgeScore(int[] edges) {
        
        int n = edges.length;
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[edges[i]]++;
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (scores[i] > max) {
                max = scores[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}