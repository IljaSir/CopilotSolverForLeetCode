class Solution {
    public int countHighestScoreNodes(int[] parents) {
        
        int n = parents.length;
        int[] count = new int[n];
        int[] score = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int p = parents[i];
            if (p != -1) {
                count[p]++;
            }
        }
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            int p = parents[i];
            if (p != -1) {
                score[p] += score[i] + 1;
            }
            max = Math.max(max, score[i] + 1);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (score[i] + 1 == max) {
                res++;
            }
        }
        return res;
    }
}