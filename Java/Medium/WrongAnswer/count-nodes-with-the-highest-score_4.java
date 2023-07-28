class Solution {
    public int countHighestScoreNodes(int[] parents) {
        
        int n = parents.length;
        int[] count = new int[n];
        int[] score = new int[n];
        int max = 0;
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            count[i] = 1;
            score[i] = 1;
            if (parents[i] >= 0) {
                count[parents[i]] += count[i];
                score[parents[i]] *= score[i] + count[i];
            }
            if (score[i] > max) {
                max = score[i];
                res = count[i];
            } else if (score[i] == max) {
                res += count[i];
            }
        }
        return res;
    }
}