class Solution {
    public int edgeScore(int[] edges) {
        
        int[] score = new int[edges.length];
        for (int i = 0; i < edges.length; i++) {
            score[edges[i]] += i;
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < edges.length; i++) {
            if (score[i] > max) {
                max = score[i];
                index = i;
            }
        }
        return index;
    }
}