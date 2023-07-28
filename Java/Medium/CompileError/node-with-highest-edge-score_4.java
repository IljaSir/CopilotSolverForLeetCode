class Solution {
    public int edgeScore(int[] edges) {
        
        int[] scores = new int[edges.length];
        for (int i = 0; i < edges.length; i++) {
            scores[edges[i]] += i;
        }
        int max = 0;
        int maxIndex = 0;
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