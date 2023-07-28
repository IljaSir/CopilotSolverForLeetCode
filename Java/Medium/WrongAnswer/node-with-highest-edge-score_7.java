class Solution {
    public int edgeScore(int[] edges) {
        
        int[] inDegree = new int[edges.length];
        for (int i = 0; i < edges.length; i++) {
            inDegree[edges[i]]++;
        }
        int maxScore = 0;
        int maxScoreNode = 0;
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] > maxScore) {
                maxScore = inDegree[i];
                maxScoreNode = i;
            }
        }
        return maxScoreNode;
    }
}