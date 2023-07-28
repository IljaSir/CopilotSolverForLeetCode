class Solution {
    public int edgeScore(int[] edges) {
        
        int[] edgeScore = new int[edges.length];
        for (int i = 0; i < edges.length; i++) {
            edgeScore[edges[i]]++;
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < edgeScore.length; i++) {
            if (edgeScore[i] > max) {
                max = edgeScore[i];
                index = i;
            }
        }
        return index;
    }
}