class Solution {
    public int edgeScore(int[] edges) {
        
        int max = 0, maxIndex = 0;
        int[] scores = new int[edges.length];
        for (int i = 0; i < edges.length; i++) {
            scores[edges[i]]++;
        }
        for (int i = 0; i < edges.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
    }
}